package com.example.unit_06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoadGameActivity : AppCompatActivity() {
    class GameActivity: AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_load_game)
        }
    }
}