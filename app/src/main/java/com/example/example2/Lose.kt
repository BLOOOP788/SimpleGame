package com.example.example2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.jar.Attributes

class Lose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)
        val intent1=intent.getIntExtra(LOSE_ID,0)
        val intent2=intent.getStringExtra(Name_ID)
        val showScore=findViewById<TextView>(R.id.tvLoseScore)
        val showName=findViewById<TextView>(R.id.tvNameLose)
        showName.text=intent2
        showScore.text=intent1.toString()

        change(intent2.toString(),intent1)
    }
    private fun change(name:String,score:Int){
        val btChart=findViewById<Button>(R.id.btLoseChart)

        btChart.setOnClickListener(){
            val intent= Intent(this,Chart::class.java).apply {
                putExtra(LOSE_ID,score)
                putExtra(Name_ID,name)
            }

            startActivity(intent, null)
        }
    }
}