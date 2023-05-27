package com.todokanai.busstop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.todokanai.busstop.R
import com.todokanai.busstop.adapter.BusArriveRecyclerAdapter
import com.todokanai.busstop.databinding.FragmentBusArriveBinding
import com.todokanai.busstop.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BusArriveFragment : Fragment() {

    private lateinit var binding : FragmentBusArriveBinding
    private val viewModel : MapViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bus_arrive,container,false)

        val adapter = BusArriveRecyclerAdapter()
        binding.busRecyclerView.adapter = adapter
        binding.busRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.swipeLayout.setOnRefreshListener {
            // 여기서 viewModel의 데이터 변경 메소드 실행
            viewModel.updateArrive()
            binding.swipeLayout.isRefreshing = false
        }

        viewModel.arriveDataHolder.observe(viewLifecycleOwner){
            adapter.itemList = it
            adapter.notifyDataSetChanged()
        }



        return binding.root
    }
}