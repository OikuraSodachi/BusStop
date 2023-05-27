package com.todokanai.busstop.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.busstop.R
import com.todokanai.busstop.room.retrofitdata.Station

class StartEndViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var station : Station? = null
    private val stationName = itemView.findViewById<TextView>(R.id.stationName)
    val itemDelete = itemView.findViewById<ImageButton>(R.id.itemDelete)

    init {
        itemView.setOnClickListener {
            station?.let {
                setItem(station!!)

            }
        }
        itemDelete.setOnClickListener {

        }

    }

    fun setItem(station: Station){
        stationName.text = station.nodenm
        // 대충 함수 내용

        this.station = station
    }
}