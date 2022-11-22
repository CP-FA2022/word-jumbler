package com.example.jumbler.fragments

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
import com.example.jumbler.R
import com.example.jumbler.activities.GameActivity

class LaunchGameFragment: Fragment() {
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

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}