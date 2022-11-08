package com.example.unit_06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.R.id
import androidx.appcompat.app.AppCompatActivity

class GameOver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)

        val btnNewGame2: Button = findViewById(R.id.btnNewGame2)
        btnNewGame2.setOnClickListener {
            startActivity(Intent(baseContext, GameActivity::class.java))
        }
    }
}