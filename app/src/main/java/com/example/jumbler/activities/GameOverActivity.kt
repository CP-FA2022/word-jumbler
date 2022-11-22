package com.example.jumbler.activities
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jumbler.R
import com.example.jumbler.adapters.SolutionsAdapter

class GameOverActivity : AppCompatActivity() {

    private val tvFinalScore: TextView by lazy { findViewById(R.id.tvFinalScore) }
    private val tvWordCount: TextView by lazy { findViewById(R.id.tvWordCount) }
    private val rvSolutions: RecyclerView by lazy { findViewById(R.id.rvSolutions) }
    private val btnRestart: Button by lazy { findViewById(R.id.btnRestart) }
    private val btnHome: Button by lazy { findViewById(R.id.btnHome) }
    private lateinit var solutionsAdapter: SolutionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val solutions = intent.getSerializableExtra("solutions") as ArrayList<*>
        val finalScore = intent.getIntExtra("score", 0)
        tvFinalScore.text = "You scored: ${finalScore}"
        tvWordCount.text = "You jumbled ${solutions.size} words!"

        rvSolutions.apply {
            layoutManager = LinearLayoutManager(context)
            solutionsAdapter = SolutionsAdapter(solutions as ArrayList<String>)
            adapter = solutionsAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

        btnRestart.setOnClickListener {
            startActivity(Intent(baseContext, GameActivity::class.java))
            finish()
        }
        btnHome.setOnClickListener {
            startActivity(Intent(baseContext, MainActivity::class.java))
            finish()
        }
    }
}