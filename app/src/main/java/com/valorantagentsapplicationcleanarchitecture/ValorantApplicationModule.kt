package com.valorantagentsapplicationcleanarchitecture

import com.valorantagentsapplicationcleanarchitecture.network.ApiCommunicator
import com.valorantagentsapplicationcleanarchitecture.utils.ValozConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ValorantApplicationModule {

    @Provides
    @Singleton
    fun provideValorantAgentsApi(): ApiCommunicator {
        return Retrofit.Builder()
            .baseUrl(ValozConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCommunicator::class.java)
    }

}