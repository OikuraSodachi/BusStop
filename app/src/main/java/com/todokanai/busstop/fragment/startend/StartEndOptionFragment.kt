package com.todokanai.busstop.fragment.startend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.todokanai.busstop.R
import com.todokanai.busstop.databinding.FragmentStartEndOptionBinding
import com.todokanai.busstop.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartEndOptionFragment : Fragment() {

    private lateinit var binding : FragmentStartEndOptionBinding
    private val viewModel : MapViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_start_end_option,container,false)

        val startModeBtn = binding.startModeBtn
        val defaultModeBtn = binding.defaultModeBtn
        val endModeBtn = binding.endModeBtn

        startModeBtn.setOnClickListener { viewModel.startMode() }
        defaultModeBtn.setOnClickListener { viewModel.defaultMode() }
        endModeBtn.setOnClickListener { viewModel.endMode() }



        // Inflate the layout for this fragment
        return binding.root
    }

}