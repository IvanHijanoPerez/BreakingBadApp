package com.example.breakingbadapp.di

import com.example.breakingbadapp.common.Constants
import com.example.breakingbadapp.data.remote.BreakingBadApi
import com.example.breakingbadapp.data.repository.CharacterRepositoryImpl
import com.example.breakingbadapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBreakingBadApi(): BreakingBadApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BreakingBadApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: BreakingBadApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}