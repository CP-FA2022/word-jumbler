package com.example.jumbler.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.jumbler.R
import com.example.jumbler.fragments.LaunchGameFragment
import com.example.jumbler.fragments.LeaderboardFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val bottomNavigationView: BottomNavigationView by lazy { findViewById(R.id.btmNavView) }
    private val launchGameFragment: Fragment = LaunchGameFragment()
    private val leaderboardFragment: Fragment = LeaderboardFragment()
    private val tvHelloPlayer: TextView by lazy { findViewById(R.id.tvHelloPlayer) }
    private val btnLogout: Button by lazy { findViewById(R.id.btnLogout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = Firebase.auth.currentUser
        user?.let {
            val name = user.displayName
            val email = user.email
            val uid = user.uid

            if (intent.hasExtra("name")) {
                tvHelloPlayer.text = "Hello, ${intent.getStringExtra("name")}!"
            } else {
                tvHelloPlayer.text = "Hello, ${name}!"
            }
        }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, AuthenticationActivity::class.java)
            startActivity(intent)
        }

        val fragmentManager: FragmentManager = supportFragmentManager
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.itemLaunchGame -> fragment = launchGameFragment
                R.id.itemLeaderboard-> fragment = leaderboardFragment
            }
            fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
            true
        }
    }

}