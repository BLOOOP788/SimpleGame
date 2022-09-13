package com.example.example2

import android.content.Intent
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val Name_ID="com.example.example2.name"

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

    }

     fun register(view: View) {
        val btStart=findViewById<Button>(R.id.btStart)
        val etName=findViewById<EditText>(R.id.etName)

         if(etName.text.isNotEmpty()){
                val name=etName.text.toString()
                val intent= Intent(this,MainActivity::class.java).apply {
                    putExtra(Name_ID,name)
                }
                startActivity(intent, null)
            }else{
                Toast.makeText(this,"Use a Name Please", Toast.LENGTH_LONG).show()
            }

    }
}