package com.example.jumbler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jumbler.R
import com.example.jumbler.models.LeaderboardRecord

class LeaderboardAdapter(data: MutableList<LeaderboardRecord>) : RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>(){
    private var leaderboard = data
    fun setLeaderboardData(data: MutableList<LeaderboardRecord>) {
        this.leaderboard = data
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvRank: TextView = view.findViewById(R.id.tvRank)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvScore: TextView = view.findViewById(R.id.tvLeaderScore)
        fun bind(record: LeaderboardRecord, rank: Int) {
            tvRank.text = (rank + 1).toString()
            tvName.text = record.displayName
            tvScore.text = record.points.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_leaderboard, parent, false)
        return LeaderboardAdapter.ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: LeaderboardAdapter.ViewHolder, position: Int) {
        holder.bind(leaderboard[position], position)
    }

    override fun getItemCount(): Int {
        return leaderboard.size
    }
}