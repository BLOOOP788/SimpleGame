package com.example.example2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Chart : AppCompatActivity() {
    lateinit var players: ArrayList<Player>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        loadPlayers()
        initRecyclerView()
        returnToStart()
    }
    private fun loadPlayers(){
        players=ArrayList()
        players.add(Player("Juan",12))
        players.add(Player("Pedro",4))
        players.add(Player("Milena",5))
        val intent1=intent.getIntExtra(LOSE_ID,0)
        val intent2=intent.getStringExtra(Name_ID)
        players.add(Player(intent2.toString(),intent1))
        players.sortByDescending {list->list.Score }
    }
    private  fun initRecyclerView(){
        val recyclerView=findViewById<RecyclerView>(R.id.rvChart)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=ChartAdapter(players)
    }
     fun returnToStart(){
         val btStartReturn=findViewById<Button>(R.id.btReturnStart)
         btStartReturn.setOnClickListener(){
             val intent = Intent(this, Register::class.java)
             startActivity(intent, null)
         }
    }
}