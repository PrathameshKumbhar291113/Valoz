package com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.valorantagentsapplicationcleanarchitecture.databinding.AgentItemBinding
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import com.valorantagentsapplicationcleanarchitecture.utils.createGradientDrawable


class AgentsAdapter(
    val onClick: (AgentsResponse.Data?) -> Unit
) : RecyclerView.Adapter<AgentsAdapter.AgentsViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<AgentsResponse.Data>() {
        override fun areItemsTheSame(
            oldItem: AgentsResponse.Data,
            newItem: AgentsResponse.Data
        ): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(
            oldItem: AgentsResponse.Data,
            newItem: AgentsResponse.Data
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        return AgentsViewHolder(
            AgentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) =
        holder.bind(differ.currentList[position])

    inner class AgentsViewHolder(private val binding: AgentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(agentData: AgentsResponse.Data?) {
            var gradientDrawable = createGradientDrawable(agentData?.backgroundGradientColors, 90)

            binding.displayNameTxt.text = agentData?.displayName

            binding.agentPortraitImage.apply {
                load(agentData?.fullPortraitV2) {
                    crossfade(true)
                }

            }

            binding.agentBackgroundImage.apply {
                load(agentData?.background) {
                    crossfade(true)
                }
            }

            binding.agentDisplayIcon.apply {
                load(agentData?.displayIconSmall) {
                    crossfade(true)
                }
                setOnClickListener { onClick(agentData) }
            }
        }

    }

}