package com.valorantagentsapplicationcleanarchitecture.network

import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import com.valorantagentsapplicationcleanarchitecture.utils.ValozConstants.GET_AGENTS
import retrofit2.Response
import retrofit2.http.GET

interface ApiCommunicator {
    @GET(GET_AGENTS)
    suspend fun getAgents() : Response<AgentsResponse>
}