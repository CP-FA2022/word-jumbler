package com.example.jumbler.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jumbler.R
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var words: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        try {
            val inputStream = baseContext.assets.open("valid.txt")
            val bufferedReader = inputStream.bufferedReader()
            words = bufferedReader.readLines() as ArrayList<String>

        } catch(e: java.lang.Exception) {
            println("Couldn't read file.")
        }
    }
}