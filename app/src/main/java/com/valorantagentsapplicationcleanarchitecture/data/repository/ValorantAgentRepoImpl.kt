package com.valorantagentsapplicationcleanarchitecture.data.repository

import com.valorantagentsapplicationcleanarchitecture.domain.repository.ValorantAgentsRepository
import com.valorantagentsapplicationcleanarchitecture.network.ApiCommunicator
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import retrofit2.Response
import javax.inject.Inject

class ValorantAgentRepoImpl @Inject constructor(
    private val apiCommunicator: ApiCommunicator
) : ValorantAgentsRepository{
    override suspend fun getValorantAgentsList(): Response<AgentsResponse> {
        return apiCommunicator.getAgents()
    }
}