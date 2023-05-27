package com.todokanai.busstop.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.VisibleRegion
import com.todokanai.busstop.Constants.STATUS_DEFAULT
import com.todokanai.busstop.Constants.STATUS_END
import com.todokanai.busstop.Constants.STATUS_START
import com.todokanai.busstop.R
import com.todokanai.busstop.databinding.FragmentMapBinding
import com.todokanai.busstop.room.retrofitdata.Station
import com.todokanai.busstop.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : Fragment() , OnMarkerClickListener{

    private val allStationList by lazy{viewModel.allStationListHolder}
    private lateinit var binding : FragmentMapBinding
    private val viewModel : MapViewModel by activityViewModels()
    private val visibleStationList = mutableListOf<Station>()
    private var markerTrigger : Boolean = false
    private val cameraZoom = MutableLiveData<Float>()
    val visibleRegion = MutableLiveData<VisibleRegion>()        // map 범위 감지변수.  map 관련 데이터 변경 트리거
    var disableClear : Boolean = true

    private val callback = OnMapReadyCallback { googleMap ->

        fun isStationInScreen(station: Station) = googleMap.projection.visibleRegion.latLngBounds.contains(station.getLatLng())
        // safe

        fun createMarker(station: Station){
            val latLng = LatLng(station.gpslati,station.gpslong)
            googleMap.addMarker(MarkerOptions()
                .position(latLng)
                .title(station.nodenm)
                .snippet(station.nodeid)
            )
        }       // safe

        fun filterVisibleStation(){
            visibleStationList.clear()
            for( index in 0..allStationList.size - 1){
                if(isStationInScreen(allStationList[index])) {
                    visibleStationList.add(allStationList[index])
                }
            }
        }           // visibleStationList 값 세팅   // safe

        visibleRegion.observe(viewLifecycleOwner){
            val cPosition = googleMap.cameraPosition
            cameraZoom.value = cPosition.zoom
            viewModel.insertCameraFocus(cPosition.zoom,cPosition.target.latitude,cPosition.target.longitude)

            filterVisibleStation()

            if(markerTrigger) {  //  일정 배율 이상 확대상태라면
                for ( index in 0..visibleStationList.size - 1) {
                    createMarker(visibleStationList[index])
                }
                println("generated:${visibleStationList.size}")
                googleMap.setOnMarkerClickListener(this)
            }
        }


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(viewModel.cameraLat,viewModel.cameraLng),viewModel.cameraZoom))

        googleMap.setOnCameraIdleListener {
            val mVisibleRegion = googleMap.projection.visibleRegion

            if(!disableClear) {
                googleMap.clear()
                println("clear")
                visibleRegion.value = mVisibleRegion
            }else{
                disableClear = false
                visibleRegion.value = mVisibleRegion
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_map,container,false)
        viewModel.prepareAllStation()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MapFragment","onViewCreated")
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        cameraZoom.observe(viewLifecycleOwner){
            Log.d("zoom","zoom: $it")
            markerTrigger = it>15
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        val selectedStation : Station = allStationList.filter{it.nodeid == marker.snippet.toString()}[0] // 선택된 Station
        val selectedNodeId = selectedStation.nodeid
        val selectedName = selectedStation.nodenm
        viewModel.updateCurrentNodeId(selectedNodeId)
        when(viewModel.map_status.value) {

            STATUS_DEFAULT -> {
                viewModel.updateArrive()

                // 여기에 BusArriveFragment의 onSwipeRefresh 작동시키는 코드
            }
            STATUS_START -> {
                viewModel.addToStart(selectedStation)
                viewModel.updateThroughLine(selectedNodeId)

            }                      // 시작점 모드일때 onMarkerClick
            STATUS_END -> {
                viewModel.addToEnd(selectedStation)
                viewModel.updateThroughLine(selectedNodeId)
            }                        // 도착점 모드일때 onMarkerClick
        }
        disableClear = true
        return false
    }
}