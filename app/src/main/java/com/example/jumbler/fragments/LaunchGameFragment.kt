package com.example.jumbler.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        btnLaunch.setOnClickListener {
            val intent = Intent(view.context, GameActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}