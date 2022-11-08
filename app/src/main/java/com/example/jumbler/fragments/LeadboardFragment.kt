package com.example.jumbler.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jumbler.R

class LeadboardFragment : Fragment() {

    companion object {
        fun newInstance() = LeadboardFragment()
    }

    private lateinit var viewModel: LeadboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_leadboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LeadboardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}