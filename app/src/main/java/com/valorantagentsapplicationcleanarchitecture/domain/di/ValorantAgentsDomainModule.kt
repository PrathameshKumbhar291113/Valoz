package com.valorantagentsapplicationcleanarchitecture.domain.di

import com.valorantagentsapplicationcleanarchitecture.domain.repository.ValorantAgentsRepository
import com.valorantagentsapplicationcleanarchitecture.domain.use_case.ValorantAgentsUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ValorantAgentsDomainModule {
    fun getValorantAgents(
        valorantAgentsRepository: ValorantAgentsRepository
    ): ValorantAgentsUseCase{
        return ValorantAgentsUseCase(valorantAgentsRepository)
    }
}