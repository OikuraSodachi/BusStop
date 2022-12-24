package com.todokanai.busstop.activity

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.todokanai.busstop.R
import com.todokanai.busstop.service.MyService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("oikura","MainActivity_onCreate")

        val intentService = Intent(this, MyService::class.java)
        startService(intentService)    //----- 서비스 개시



    }
}