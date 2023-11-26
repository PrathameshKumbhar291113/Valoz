package com.valorantagentsapplicationcleanarchitecture.presentation.agents_details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgentDetailsViewModel @Inject constructor() : ViewModel(){
    private val _agentDetails = MutableLiveData<AgentsResponse.Data?>()
    val agentDetails : LiveData<AgentsResponse.Data?>  get() = _agentDetails

    fun getAgentsDetails(agentDetails : AgentsResponse.Data?){
        agentDetails?.let {data ->
            _agentDetails.postValue(data)
        }

    }
}