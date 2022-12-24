package com.todokanai.busstop.fragment

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.todokanai.busstop.CsvHelper
import com.todokanai.busstop.R
import com.todokanai.busstop.activity.MapActivity
import com.todokanai.busstop.databinding.FragmentMainBinding
import com.todokanai.busstop.myobjects.MyObjects.csvPath
import com.todokanai.busstop.myobjects.MyObjects.storedData
import com.todokanai.busstop.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

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

        val insertBtn = binding.insertBtn
        val getBtn = binding.getBtn
        val logBtn = binding.logBtn
        val inputString = binding.inputString.text
        val inputLong = binding.inputLong.text

        /*
        insertBtn.setOnClickListener { viewModel.insert(User(inputText.toString().toLong(),1)) }
        getBtn.setOnClickListener { Log.d("tester", "Fragment: ${userListInfo}") }
        logBtn.setOnClickListener {}
         */

        insertBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.insertBtn()
            }
        }


        getBtn.setOnClickListener {

        }

        val intentMap = Intent(requireActivity(),MapActivity::class.java)
        logBtn.setOnClickListener { startActivity(intentMap) }

        return binding.root
    }
}