package com.valorantagentsapplicationcleanarchitecture.data.di

import com.google.gson.GsonBuilder
import com.valorantagentsapplicationcleanarchitecture.data.repository.ValorantAgentRepoImpl
import com.valorantagentsapplicationcleanarchitecture.domain.repository.ValorantAgentsRepository
import com.valorantagentsapplicationcleanarchitecture.network.ApiCommunicator
import com.valorantagentsapplicationcleanarchitecture.utils.ValozConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ValorantAgentHiltDataModule {

    @Provides
    @Singleton
    fun providesValorantAgentsRepository(
        apiCommunicator: ApiCommunicator
    ): ValorantAgentsRepository{
        return ValorantAgentRepoImpl(apiCommunicator = apiCommunicator)
    }
}