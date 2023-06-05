package com.example.shcpcsd.di

import com.example.shcpcsd.data.api.ShcpcsdApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModuleProvides {
    @Singleton
    @Provides
    fun provideDentistryApi(): ShcpcsdApi {
        return ShcpcsdApi.create()
    }
}