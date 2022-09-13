package com.example.example2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val LOSE_ID="com.example.example2.message"
class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position=0
    var puntaje=0
    var vidas=3
    var racha=0
    var name=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadName()
        loadQuestions()
        setupViews()
    }

    private fun loadName() {
        val intent=intent.getStringExtra(Name_ID)
        val showName=findViewById<TextView>(R.id.tvNameMain)

        showName.text=intent
        name=showName.text.toString()
    }

    private fun loadQuestions(){
        questions=ArrayList()
        var question=Question("¿Es lima una capital?",true)
        questions.add(question)
        questions.add(Question("¿Si Piura una ciudad?",true))
        questions.add(Question("¿Si Hiraoka una ciudad?",false))
        questions.add(Question("¿Si Turip ip ip  una cancion?",true))
        questions.add(Question("¿Hace ruido un árbol al caer si nadie está ahí para escucharlo?",true))
        questions.add(Question("¿Aprobaras el curso?",false))
        questions.add(Question("¿Estas bien?",true))
    }
    private  fun checkLife(lives:Int){
        if(lives<=0){
            vidas=0

            val puntajeToSend=puntaje
            val intent= Intent(this,Lose::class.java).apply {
                putExtra(LOSE_ID,puntajeToSend)
                putExtra(Name_ID,name)
            }

            startActivity(intent, null)
        }
    }
    private fun nextAutomated(){
        val showQuestion=findViewById<TextView>(R.id.tvQuestion)
        if(position<questions.size-1){
            position++
            showQuestion.text=questions[position].sentence
        }else{
            val puntajeToSend=puntaje
            val intent= Intent(this,Win::class.java).apply {
                putExtra(LOSE_ID,puntajeToSend)
                putExtra(Name_ID,name)
            }
            startActivity(intent,null)
        }

    }
    private fun setupViews(){
        val btYes=findViewById<Button>(R.id.btYes)
        val btNo=findViewById<Button>(R.id.btNo)

        val showQuestion=findViewById<TextView>(R.id.tvQuestion)
        val showScore=findViewById<TextView>(R.id.tvScore)
        val showLife=findViewById<TextView>(R.id.tvLife)
        showQuestion.text=questions[position].sentence
        showLife.text=vidas.toString()
        showScore.text=puntaje.toString()

      /*  btNext.setOnClickListener {
            if(position==questions.size && vidas>0){
                val puntajeToSend=puntaje.toString()
                val intent= Intent(this,Win::class.java).apply {
                    putExtra(LOSE_ID,puntajeToSend)
                }
                startActivity(intent)
            }
            position++
            showQuestion.text=questions[position].sentence

        }*/
        btYes.setOnClickListener {
            if(questions[position].answer){
                Toast.makeText(this,"Correct",Toast.LENGTH_LONG).show()
                puntaje++
                showScore.text=puntaje.toString()
                nextAutomated()
            }else {
                if(puntaje>0){
                    puntaje--
                }
                checkLife(vidas)
                vidas--
                showScore.text = puntaje.toString()
                showLife.text=vidas.toString()
                Toast.makeText(this,"Incorrect",Toast.LENGTH_LONG).show()
                nextAutomated()
            }
        }
        btNo.setOnClickListener {
            if(questions[position].answer){
            Toast.makeText(this,"Incorrect",Toast.LENGTH_LONG).show()
                if(puntaje>0){
                    puntaje--
                }
                checkLife(vidas)
                vidas--
                showScore.text=puntaje.toString()
                showLife.text=vidas.toString()
                nextAutomated()
        }else{
                puntaje++
                showScore.text=puntaje.toString()
                Toast.makeText(this,"correct",Toast.LENGTH_LONG).show()
                nextAutomated()
            }
        }
    }
}