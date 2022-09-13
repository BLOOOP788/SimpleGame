package com.example.example2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Win : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        val intent1=intent.getIntExtra(LOSE_ID,0)
        val intent2=intent.getStringExtra(Name_ID)
        val showName=findViewById<TextView>(R.id.tvNameWin)
        val showScore=findViewById<TextView>(R.id.tvScoreWin)
        showScore.text=intent1.toString()
        showName.text=intent2
        change(intent2.toString(),intent1)
    }
    private fun change(name:String,score:Int){
        val btChart=findViewById<Button>(R.id.btWinChart)

        btChart.setOnClickListener(){
            val intent= Intent(this,Chart::class.java).apply {
                putExtra(LOSE_ID,score)
                putExtra(Name_ID,name)
            }

            startActivity(intent, null)
        }
    }
}