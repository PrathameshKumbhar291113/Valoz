package com.valorantagentsapplicationcleanarchitecture.presentation.agents_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.valorantagentsapplicationcleanarchitecture.databinding.AgentItemAbilityBinding
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse

class AgentAbilityAdapter() : RecyclerView.Adapter<AgentAbilityAdapter.AgentAbilityViewHolder>(){

    private val diffCallback = object : DiffUtil.ItemCallback<AgentsResponse.Data.Ability>() {

        override fun areItemsTheSame(
            oldItem: AgentsResponse.Data.Ability,
            newItem: AgentsResponse.Data.Ability
        ): Boolean {
            return oldItem.slot == newItem.slot
        }

        override fun areContentsTheSame(
            oldItem: AgentsResponse.Data.Ability,
            newItem: AgentsResponse.Data.Ability
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    inner class AgentAbilityViewHolder(
        private val binding: AgentItemAbilityBinding
    ):  RecyclerView.ViewHolder(
        binding.root
    ){
        fun bind(agentAbility: AgentsResponse.Data.Ability){
            binding.agentAbilityIcon.load(agentAbility.displayIcon)
            binding.agentAbilityName.text = agentAbility.displayName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentAbilityViewHolder {
        return AgentAbilityViewHolder(
            AgentItemAbilityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: AgentAbilityViewHolder, position: Int) = holder.bind(differ.currentList[position])
}