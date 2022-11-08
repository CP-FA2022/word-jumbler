package com.example.jumbler.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.jumbler.R
import com.example.jumbler.fragments.LaunchGameFragment
import com.example.jumbler.fragments.LeadboardFragment
import com.example.jumbler.fragments.LoadGameFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.btmNavView) }
    private val launchGameFragment: Fragment = LaunchGameFragment()
    private val loadGameFragment: Fragment = LoadGameFragment()
    private val leaderboardFragment: Fragment = LeadboardFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.itemLaunchGame -> fragment = launchGameFragment
                R.id.itemLeaderboard-> fragment = leaderboardFragment
                R.id.itemLoadGame-> fragment = loadGameFragment
            }
            fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
            true
        }
    }

}