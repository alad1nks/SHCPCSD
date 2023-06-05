package com.example.shcpcsd.di

import com.example.shcpcsd.data.repository.SensorsRepository
import com.example.shcpcsd.data.repository.SensorsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun bindSensorsRepository(repo: SensorsRepositoryImpl): SensorsRepository
}