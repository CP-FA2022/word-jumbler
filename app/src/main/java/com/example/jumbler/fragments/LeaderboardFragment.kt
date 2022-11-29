package com.example.jumbler.fragments

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jumbler.R
import com.example.jumbler.adapters.LeaderboardAdapter
import com.example.jumbler.adapters.SolutionsAdapter
import com.example.jumbler.models.FirestoreViewModel
import com.example.jumbler.models.LeaderboardRecord

class LeaderboardFragment : Fragment() {

    private lateinit var firestoreViewModel: FirestoreViewModel
    var leaderboard: List<LeaderboardRecord> = mutableListOf()

    lateinit var leaderboardAdapter: LeaderboardAdapter

    companion object {
        fun newInstance() = LeaderboardFragment()
    }

    private lateinit var viewModel: LeadboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        firestoreViewModel.getLeaderboard().observe(viewLifecycleOwner, Observer { it ->
            leaderboard = it
            val rvLeaderboard: RecyclerView =  view.findViewById(R.id.rvLeaderboard)
            rvLeaderboard.apply {
                layoutManager = LinearLayoutManager(context)
                leaderboardAdapter = LeaderboardAdapter(leaderboard.take(10) as MutableList<LeaderboardRecord>)
                adapter = leaderboardAdapter
                addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            }
        })

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firestoreViewModel = ViewModelProvider(this)[FirestoreViewModel::class.java]

    }
}