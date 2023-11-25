package com.valorantagentsapplicationcleanarchitecture.domain.repository

import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import retrofit2.Response

interface ValorantAgentsRepository {
    suspend fun getValorantAgentsList() : Response<AgentsResponse>
}