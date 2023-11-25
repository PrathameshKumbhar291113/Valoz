package com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.valorantagentsapplicationcleanarchitecture.R
import com.valorantagentsapplicationcleanarchitecture.databinding.FragmentAgentsScreenBinding


class AgentsScreenFragment : Fragment() {
    private lateinit var binding: FragmentAgentsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentAgentsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

}