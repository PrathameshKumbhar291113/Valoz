package com.valorantagentsapplicationcleanarchitecture.presentation.agents_details.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.valorantagentsapplicationcleanarchitecture.databinding.FragmentAgentDetailsBinding
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import com.valorantagentsapplicationcleanarchitecture.presentation.agents_details.adapter.AgentAbilityAdapter
import com.valorantagentsapplicationcleanarchitecture.presentation.agents_details.viewmodel.AgentDetailsViewModel
import com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.fragments.AgentsScreenFragment
import com.valorantagentsapplicationcleanarchitecture.utils.createGradientDrawable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAgentDetailsBinding
    private val agentDetailsViewModel: AgentDetailsViewModel by activityViewModels()
    private lateinit var agentAbilityAdapter: AgentAbilityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getAgentData =
            arguments?.getParcelable<AgentsResponse.Data>(AgentsScreenFragment.AGENT_DATA)

        agentDetailsViewModel.getAgentsDetails(getAgentData)
        setupUI()
        setUpObservers()
    }

    private fun setUpObservers() {
        agentDetailsViewModel.agentDetails.observe(viewLifecycleOwner) {
            it?.let { agentData ->
                Log.e("Prathamesh", "setUpObservers: ${agentData.displayName}")
                binding.agentName.text = agentData.displayName
                binding.agentDesc.text = agentData.description
                binding.agentBackground.load(agentData.background)
                binding.agentImage.load(agentData.fullPortraitV2)
                binding.backgroundColor.background =
                    createGradientDrawable(agentData.backgroundGradientColors, 90)
                setupAgentAbilityRecyclerView(agentData.abilities, agentData.role)
                setupStatusBarColor(agentData)
                binding.agentRoleIcon.load(agentData.role?.displayIcon)
                binding.agentRoleName.text = agentData.role?.displayName
            }
        }
    }

    private fun setupAgentAbilityRecyclerView(
        ability: List<AgentsResponse.Data.Ability?>?,
        role: AgentsResponse.Data.Role?
    ) {
        agentAbilityAdapter = AgentAbilityAdapter()
        binding.abilityDisplayRecyclerView.adapter = agentAbilityAdapter
        agentAbilityAdapter.differ.submitList(ability)



    }

    private fun setupStatusBarColor(agentData: AgentsResponse.Data) {
        val statusBarColorString =
            "#${agentData.backgroundGradientColors?.getOrNull(3) ?: "000000"}"
        val statusBarColor = Color.parseColor(statusBarColorString)
        requireActivity().window.statusBarColor = statusBarColor
    }

    private fun setupUI() {
        handleOnBackPress()
    }

    private fun handleOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
    }

}
