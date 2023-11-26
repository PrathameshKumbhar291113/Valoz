package com.valorantagentsapplicationcleanarchitecture.domain.use_case

import com.valorantagentsapplicationcleanarchitecture.domain.repository.ValorantAgentsRepository
import com.valorantagentsapplicationcleanarchitecture.network.models.AgentsResponse
import com.valorantagentsapplicationcleanarchitecture.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class ValorantAgentsUseCase @Inject constructor(
    private val valorantAgentsRepository: ValorantAgentsRepository
) {
    operator fun invoke() = flow<NetworkResult<Response<AgentsResponse>>> {
        emit(NetworkResult.Loading())
        emit(NetworkResult.Success(data = valorantAgentsRepository.getValorantAgentsList()))
    }.catch {
        emit(NetworkResult.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}