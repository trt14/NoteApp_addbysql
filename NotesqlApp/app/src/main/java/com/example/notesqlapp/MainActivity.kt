package com.example.notesqlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtxt :EditText
    lateinit var btn :Button
    lateinit var note:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtxt = findViewById(R.id.edtxt)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            note=edtxt.text.toString()

            var dbhr = dbhelper(applicationContext)
           var status =  dbhr.saveNote(note)
            if(status<0){
                Toast.makeText(applicationContext,"Note Added failed",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(applicationContext,"Note Added successful$status",Toast.LENGTH_SHORT).show()

            }


        }
    }
}