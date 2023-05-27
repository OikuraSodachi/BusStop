package com.todokanai.busstop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.busstop.R
import com.todokanai.busstop.room.retrofitdata.BusArrive
import com.todokanai.busstop.viewmodel.MapViewModel

class BusArriveRecyclerAdapter : RecyclerView.Adapter<BusArriveViewHolder>(){
//    var itemList = mutableListOf<BusArrive>()

    var itemList : List<BusArrive> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusArriveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.busarrive_recycler, parent, false)
        return BusArriveViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(busArriveViewHolder: BusArriveViewHolder, position: Int) {
        val busArrive = itemList[position]
        busArriveViewHolder.setItem(busArrive)
    }
}