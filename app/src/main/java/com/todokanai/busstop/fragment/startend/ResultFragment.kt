package com.todokanai.busstop.fragment.startend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.todokanai.busstop.Constants.STATUS_END
import com.todokanai.busstop.Constants.STATUS_START
import com.todokanai.busstop.R
import com.todokanai.busstop.adapter.ResultRecyclerAdapter
import com.todokanai.busstop.databinding.FragmentResultBinding
import com.todokanai.busstop.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding
    private val viewModel : MapViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_result,container,false)
        val startLine = mutableSetOf<String>()
        val endLine = mutableSetOf<String>()
        val resultLive = MutableLiveData<Set<String>>()

        var resultOut = emptyList<String>()

        val adapter = ResultRecyclerAdapter()
        binding.resultRecyclerView.adapter = adapter
        binding.resultRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.areaThrough.observe(viewLifecycleOwner){
            adapter.itemList = it
            adapter.notifyDataSetChanged()
        }

        viewModel.startLineDataHolder.observe(viewLifecycleOwner){
            if(viewModel.map_status.value == STATUS_START) {
                for (element in it) {
                    startLine.add(element.routeno)
                }
                resultLive.value = startLine.intersect(endLine)
                viewModel._areaThrough.value = resultOut

            }
        }

        viewModel.endLineDataHolder.observe(viewLifecycleOwner){
            if(viewModel.map_status.value == STATUS_END) {
                for (element in it) {
                    endLine.add(element.routeno)
                }
                resultLive.value = startLine.intersect(endLine)
                viewModel._areaThrough.value = resultOut
            }
        }

        resultLive.observe(viewLifecycleOwner){
            resultOut = it.toList()
            println("ttttt result: $it")
        }









        // Inflate the layout for this fragment
        return binding.root
    }

}