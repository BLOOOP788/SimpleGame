package com.example.example2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChartAdapter(private val players:ArrayList<Player>):RecyclerView.Adapter<ChartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ChartViewHolder(layoutInflater.inflate(R.layout.player_charts_prototype,parent,false))
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val item=players[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =players.size


}