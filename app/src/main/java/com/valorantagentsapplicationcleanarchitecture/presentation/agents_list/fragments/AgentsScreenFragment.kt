package com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.valorantagentsapplicationcleanarchitecture.R
import com.valorantagentsapplicationcleanarchitecture.databinding.FragmentAgentsScreenBinding
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.adapter.AgentsAdapter
import com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.viewmodel.AgentListViewModel
import com.valorantagentsapplicationcleanarchitecture.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentsScreenFragment : Fragment() {

    private lateinit var binding: FragmentAgentsScreenBinding
    private  val agentsViewModel : AgentListViewModel by activityViewModels()
    private lateinit var agentsAdapter : AgentsAdapter

    companion object{
        const val AGENT_DATA = "agent_data"
    }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        requireActivity().window.statusBarColor = requireActivity().resources.getColor(R.color.red_shade)
        handleOnBackPress()
    }

    private fun setupObservers() {
        agentsViewModel.getAgents.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Loading -> {
                }
                is NetworkResult.Success ->{
                    it.data?.let { agentsData ->
                        if (agentsData.code() == 200){
                            agentsData.body()?.data?.let { data ->
                                Log.e("Prathamesh", "setupObservers: ${data.size}")
                                setupRecyclerView(data)
                            }
                        }
                    }
                }
                is NetworkResult.Error ->{

                }
            }
        }
    }

    private fun setupRecyclerView(data: List<AgentsResponse.Data?>){
        agentsAdapter = AgentsAdapter(this::onClick)
        agentsAdapter.differ.submitList(data)
        binding.agentsRecyclerView.adapter = agentsAdapter
    }

    private fun onClick(data: AgentsResponse.Data?) {
        val agentDataBundle: Bundle = Bundle().apply {
            putParcelable(AGENT_DATA, data)
        }

        findNavController().navigate(R.id.agentDetailsFragment, agentDataBundle)
    }

    private fun handleOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            })
    }

}