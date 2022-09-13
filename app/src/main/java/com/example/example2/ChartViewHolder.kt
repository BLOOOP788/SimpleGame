package com.example.example2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChartViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val tvName=view.findViewById<TextView>(R.id.tvNamePrototype)
    val tvScore=view.findViewById<TextView>(R.id.tvScorePrototype)
    fun render(player: Player){
        tvName.text=player.Name
        tvScore.text=player.Score.toString()
    }
}