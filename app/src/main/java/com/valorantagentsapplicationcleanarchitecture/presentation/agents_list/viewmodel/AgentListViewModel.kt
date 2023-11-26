package com.valorantagentsapplicationcleanarchitecture.presentation.agents_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valorantagentsapplicationcleanarchitecture.domain.use_case.ValorantAgentsUseCase
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import com.valorantagentsapplicationcleanarchitecture.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AgentListViewModel @Inject constructor(
    private val agentsUseCase: ValorantAgentsUseCase
): ViewModel() {
    private val _getAgentList  = MutableLiveData<NetworkResult<Response<AgentsResponse>>>()
    val getAgents : LiveData<NetworkResult<Response<AgentsResponse>>> get() = _getAgentList
init {
    getAgentsList()
}
    private fun getAgentsList(){
        agentsUseCase().onEach {
            _getAgentList.postValue(it)
        }.launchIn(viewModelScope)
    }

}