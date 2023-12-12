package com.example.a2tdam_di_escalon_prada_josem_examen

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import androidx.annotation.RequiresApi




class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listado = findViewById<Button>(R.id.list)
        val create = findViewById<Button>(R.id.create)

        create.setOnClickListener{
            val intent = Intent(this, CreatePokemon::class.java)
            startActivity(intent)
        }

    }
}