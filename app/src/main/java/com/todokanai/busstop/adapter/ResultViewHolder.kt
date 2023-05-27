package com.todokanai.busstop.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.busstop.R
import com.todokanai.busstop.room.retrofitdata.ThroughLine

class ResultViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){


    private val result = itemView.findViewById<TextView>(R.id.resultTextView)

    init{

    }

    fun setItem(routeNo: String){
        result.text = routeNo


    }
}