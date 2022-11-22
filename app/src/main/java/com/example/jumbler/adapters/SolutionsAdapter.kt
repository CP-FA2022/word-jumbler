package com.example.jumbler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jumbler.R

class SolutionsAdapter(solns: ArrayList<String>) : RecyclerView.Adapter<SolutionsAdapter.ViewHolder>() {

    var solutions = solns
    fun setRecordsData(data: ArrayList<String>) {
        this.solutions = data
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvSolutionsWord: TextView = view.findViewById(R.id.tvSolutionWord)
        fun bind(soln: String) {
            tvSolutionsWord.text = soln
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolutionsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_solution, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(solutions[position])
    }

    override fun getItemCount(): Int {
        return solutions.size
    }
}
