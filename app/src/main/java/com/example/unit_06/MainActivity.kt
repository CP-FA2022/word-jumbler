package com.example.unit_06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnNewGame: Button = findViewById(R.id.btnNewGame)
        btnNewGame.setOnClickListener {
            startActivity(Intent(baseContext, GameActivity::class.java))
        }
        val btnLoadGame: Button = findViewById(R.id.btnLoadGame)
        btnLoadGame.setOnClickListener {
            startActivity(Intent(baseContext, LoadGameActivity::class.java))
        }
    }
}