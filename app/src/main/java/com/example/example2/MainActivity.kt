package com.example.example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions(){
        questions=ArrayList()
        var question=Question("Es lima una capital",true)
        questions.add(question)
        questions.add(Question("es Piura una ciudad",true))
        questions.add(Question("es Calle Inca una ciudad",false))
        questions.add(Question("es Tur ip ip  una cancion",true))
        questions.add(Question("es todo o nada",true))

    }
    private fun setupViews(){
        val btYes=findViewById<Button>(R.id.btYes)
        val btNo=findViewById<Button>(R.id.btNo)
        val btNext=findViewById<Button>(R.id.btNext)
        val showQuestion=findViewById<TextView>(R.id.tvQuestion)

        showQuestion.text=questions[position].sentence


        btNext.setOnClickListener {
            position++
            showQuestion.text=questions[position].sentence
        }
        btYes.setOnClickListener {
            if(questions[position].answer){
                Toast.makeText(this,"Correct",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Incorrect",Toast.LENGTH_LONG).show()
            }
        }
        btNo.setOnClickListener {
            if(questions[position].answer){
            Toast.makeText(this,"Incorrect",Toast.LENGTH_LONG).show()

        }else{
                Toast.makeText(this,"correct",Toast.LENGTH_LONG).show()
            }
        }
    }
}