package com.example.jumbler.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.example.jumbler.R
import com.example.jumbler.adapters.SolutionsAdapter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.JustifyContent

class GameActivity : AppCompatActivity() {

    private var words: ArrayList<String> = arrayListOf()
    private var seconds = 10

    private var vowels: ArrayList<String> = arrayListOf("A", "E", "I", "O", "U")
    private var constanants: ArrayList<String> = arrayListOf("B", "C", "D", "F", "G", "H", "J",
        "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z")

    private var guess = arrayListOf<String>()
    private var score = 0
    private var solutions = arrayListOf<String>()

    private lateinit var solutionsAdapter: SolutionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var difficulty = intent.getIntExtra("difficulty", 1)

        val progressTimer: ProgressBar = findViewById(R.id.progressTimer)
        progressTimer.max = seconds * 1000
        val timer = object : CountDownTimer((seconds * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                progressTimer.progress = ((seconds * 1000) - millisUntilFinished).toInt()
            }

            override fun onFinish() {
                val intent = Intent(this@GameActivity, GameOverActivity::class.java)
                intent.putExtra("solutions", solutions)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }

        val tvDifficulty: TextView = findViewById(R.id.tvDifficulty)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val resetBtn: Button = findViewById(R.id.btnReset)
        val btnGuess: Button = findViewById(R.id.btnGuess)

        var level: String? = null
        when(difficulty) {
            1 -> level = "Very Easy"
            2 -> level = "Easy"
            3 -> level = "Medium"
            4 -> level = "Hard"
            5 -> level = "Very Hard"
        }
        tvDifficulty.text = "Difficulty: ${level}"

        val flexLetterBank: FlexboxLayout = findViewById(R.id.flexLetterBank)
        val ids = mapOf(
            "0" to R.id.tvGuess0,
            "1" to R.id.tvGuess1,
            "2" to R.id.tvGuess2,
            "3" to R.id.tvGuess3,
            "4" to R.id.tvGuess4,
            "5" to R.id.tvGuess5,
        )


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
        for (i in 1..nVowels) {
            val rand = vowels.random()
            letters.add(rand)
        }
        for (i in 1..(nLetters - nVowels)) {
            val rand = constanants.random()
            letters.add(rand)
        }
        val layoutParams: FlexboxLayout.LayoutParams = FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(10, 10, 10, 10)
        for (i in 1..letters.size) {
            val tv = TextView(this)
            flexLetterBank.addView(tv, layoutParams)
            val params = tv.layoutParams
            params.height = 100
            params.width = 150
            tv.layoutParams = params
            tv.text = letters[i - 1]
            tv.setBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor))
            tv.gravity = Gravity.CENTER
            tv.textSize = 32F
            tv.setTextColor(ContextCompat.getColor(this, R.color.secondaryTextColor))
            tv.typeface = Typeface.DEFAULT_BOLD

            tv.setOnClickListener {
                if (guess.size == 6) {
                    Toast.makeText(this, "You can't add anymore letters!", Toast.LENGTH_SHORT).show()
                } else {
                    guess.add(tv.text.toString())
                    Log.v("Current guess",  "${guess}")
                    tv.setBackgroundColor(ContextCompat.getColor(this, R.color.primaryColor))
                    tv.setTextColor(Color.LTGRAY)
                }
                guess.forEachIndexed { index, char ->
                    val guessTile = findViewById<TextView>(ids[index.toString()]!!)
                    guessTile.text = char
                }
            }
        }
        flexLetterBank.flexDirection = FlexDirection.ROW
        flexLetterBank.justifyContent = JustifyContent.SPACE_BETWEEN
        flexLetterBank.flexWrap = FlexWrap.WRAP

        fun resetTile() {
            flexLetterBank.children.forEach {tile ->
                (tile as TextView).setBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor))
                tile.setTextColor(ContextCompat.getColor(this, R.color.secondaryTextColor))
            }
        }

        fun resetGuess() {
            guess = arrayListOf<String>()
            ids.forEach{entry ->
                val tile = findViewById<TextView>(entry.value)
                tile.text = ""
            }
        }

        resetBtn.setOnClickListener {
            resetTile()
            resetGuess()
        }

        fun submitGuess() {
            val guessWord = guess.joinToString("")
            Log.v("guess", guessWord)
            if (words.contains(guessWord.lowercase()) && (!solutions.contains(guessWord))) {
                val nGuess = guessWord.length
                score += 30 + (nGuess * 5)
                tvScore.text = "Score: ${score}"
                resetGuess()
                resetTile()
                solutions.add(guessWord)
            } else {
                Toast.makeText(this, "This word is invalid!", Toast.LENGTH_SHORT).show()
            }

        }
        btnGuess.setOnClickListener {
            submitGuess()
        }

        timer.start()
    }

}