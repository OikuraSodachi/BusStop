package com.todokanai.busstop.fragment.startend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.todokanai.busstop.R
import com.todokanai.busstop.adapter.StartEndRecyclerAdapter
import com.todokanai.busstop.databinding.FragmentStartBinding
import com.todokanai.busstop.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : Fragment() {

    private lateinit var binding : FragmentStartBinding
    private val viewModel : MapViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false)

        val startLine = mutableSetOf<String>()

        val adapter = StartEndRecyclerAdapter()
        binding.startRecyclerView.adapter = adapter
        binding.startRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.startStation.observe(viewLifecycleOwner){
            adapter.itemList = it
            adapter.notifyDataSetChanged()
        }



        return binding.root
    }
}