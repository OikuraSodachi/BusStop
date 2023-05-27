package com.todokanai.busstop.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.busstop.R
import com.todokanai.busstop.room.retrofitdata.BusArrive

class BusArriveViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){


    private val textBusNumber = itemView.findViewById<TextView>(R.id.textBusNumber)
    private val textDescription = itemView.findViewById<TextView>(R.id.textDescription)
    var busArrive : BusArrive? = null
    
    init {
        itemView.setOnClickListener {
            busArrive?.let {
                setItem(it)

            }
        }
    }

    fun setItem(busArrive: BusArrive){
        textBusNumber.text = busArrive.routeno
        textDescription.text = " 남은 정류장: ${busArrive.arrprevstationcnt}"


        // 대충 함수 내용

        this.busArrive = busArrive
    }
}