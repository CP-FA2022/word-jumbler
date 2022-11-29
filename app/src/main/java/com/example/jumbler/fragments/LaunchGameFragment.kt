package com.example.jumbler.fragments

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jumbler.R
import com.example.jumbler.activities.GameActivity
import com.example.jumbler.models.FirestoreViewModel
import com.example.jumbler.models.GameHistoryRecord
import com.example.jumbler.models.LeaderboardRecord
import com.google.firebase.Timestamp
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

class LaunchGameFragment: Fragment() {

    private lateinit var firestoreViewModel: FirestoreViewModel
    var gameHistory: List<GameHistoryRecord> = mutableListOf()

    companion object {
        fun newInstance() = Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_launch_game, container, false)
        val btnLaunch: Button = view.findViewById(R.id.btnLaunchGame)

        val seekDifficulty: SeekBar = view.findViewById(R.id.seekDifficulty)
        val tvSetDifficulty: TextView = view.findViewById(R.id.tvSetDifficulty)
        val tvHighScore: TextView = view.findViewById(R.id.tvHighScore2)
        val tvLastPlayed: TextView = view.findViewById(R.id.tvLastPlayed2)
        var finalDifficulty: Int = 1

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekDifficulty.min = 1
        }
        seekDifficulty.max = 5
        seekDifficulty.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvSetDifficulty.text = p1.toString()
                finalDifficulty = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        btnLaunch.setOnClickListener {
            val intent = Intent(view.context, GameActivity::class.java)
            intent.putExtra("difficulty", finalDifficulty)
            startActivity(intent)
        }

        firestoreViewModel.getGameHistory().observe(viewLifecycleOwner, Observer { it ->
            gameHistory = it

            val highScore: Int?
            val recentTimestamp: Timestamp?
            if (gameHistory.isNotEmpty()) {
                recentTimestamp = gameHistory.sortedByDescending { it.timestamp }[0].timestamp
                highScore = gameHistory.sortedByDescending { it.points }[0].points
            } else {
                recentTimestamp = null
                highScore = 0
            }
            tvHighScore.text = highScore.toString()

            if (recentTimestamp != null) {
                val milliseconds = recentTimestamp.seconds * 1000 + recentTimestamp.nanoseconds / 1000000
                val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm", Locale.getDefault())
                sdf.timeZone = Calendar.getInstance().timeZone
                val netDate = Date(milliseconds)
                tvLastPlayed.text = sdf.format(netDate)
            } else {
                tvLastPlayed.text = ""
            }
        })

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firestoreViewModel = ViewModelProvider(this)[FirestoreViewModel::class.java]

    }
}