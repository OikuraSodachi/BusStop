package com.todokanai.busstop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todokanai.busstop.R
import com.todokanai.busstop.room.retrofitdata.ThroughLine

class ResultRecyclerAdapter : RecyclerView.Adapter<ResultViewHolder>(){

    var itemList : List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_recycler,parent,false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val throughLine = itemList[position]
        holder.setItem(throughLine)
    }

}