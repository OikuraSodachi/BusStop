package com.todokanai.busstop.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.todokanai.busstop.R
import com.todokanai.busstop.activity.MapActivity
import com.todokanai.busstop.databinding.FragmentMainBinding
import com.todokanai.busstop.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        Log.d("oikura","MainFragment_onCreateView")

        val gitBtn = binding.gitBtn
        val busBtn = binding.busBtn
        val mapBtn = binding.mapBtn
        val inputString = binding.inputString.text
        val inputLong = binding.inputLong.text

        val intentMap = Intent(requireActivity(), MapActivity::class.java)
        startActivity(intentMap)





        mapBtn.setOnClickListener { startActivity(intentMap) }

        gitBtn.setOnClickListener{ }

        busBtn.setOnClickListener { }

            return binding.root
        }
    }