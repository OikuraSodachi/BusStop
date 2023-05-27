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
import com.todokanai.busstop.databinding.FragmentEndBinding
import com.todokanai.busstop.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EndFragment : Fragment() {

    private lateinit var binding : FragmentEndBinding
    private val viewModel : MapViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_end,container,false)

        val endLine = mutableListOf<String>()


        val adapter = StartEndRecyclerAdapter()
        binding.endRecyclerView.adapter = adapter
        binding.endRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.endStation.observe(viewLifecycleOwner){
            adapter.itemList = it
            adapter.notifyDataSetChanged()
        }





        return binding.root
    }

}