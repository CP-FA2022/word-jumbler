package com.example.jumbler.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.jumbler.R
import com.google.android.flexbox.FlexboxLayout
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var words: ArrayList<String> = arrayListOf()
    private var difficulty = 3

    private var vowels: ArrayList<String> = arrayListOf("A", "E", "I", "O", "U")
    private var constanants: ArrayList<String> = arrayListOf("B", "C", "D", "F", "G", "H", "J",
        "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val flexLetterBank: FlexboxLayout = findViewById(R.id.flexLetterBank)

        var nLetters: Int? = null

        try {
            val inputStream = baseContext.assets.open("valid.txt")
            val bufferedReader = inputStream.bufferedReader()
            words = bufferedReader.readLines() as ArrayList<String>

        } catch(e: java.lang.Exception) {
            println("Couldn't read file.")
        }

        when(difficulty) {
            1 -> nLetters = 12
            2 -> nLetters = 11
            3 -> nLetters = 10
            4 -> nLetters = 9
            5 -> nLetters = 8
        }
        var nVowels: Int = nLetters!! - 7

        var letters: ArrayList<String> = arrayListOf()
        for (i in 1..nVowels!!) {
            val rand = vowels.random()
            letters.add(rand)
        }
        for (i in 1..(nLetters!! - nVowels!!)) {
            val rand = constanants.random()
            letters.add(rand)
        }
        for (i in 1..letters.size) {
            val tv = TextView(this)
            tv.text = letters[i - 1]
            flexLetterBank.addView(tv)
        }
    }
}