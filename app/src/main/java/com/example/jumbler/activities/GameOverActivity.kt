package com.example.jumbler.activities
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unit_06.R

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