package com.todokanai.busstop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.busstop.R
import com.todokanai.busstop.room.retrofitdata.Station

class StartEndRecyclerAdapter() : RecyclerView.Adapter<StartEndViewHolder>(){

    var itemList : List<Station> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartEndViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.start_end_recycler,parent,false)
        return StartEndViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: StartEndViewHolder, position: Int) {
        val station = itemList[position]
        holder.setItem(station)
    }

}