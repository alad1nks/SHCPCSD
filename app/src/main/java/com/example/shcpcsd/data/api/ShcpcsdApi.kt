package com.example.shcpcsd.data.api

import com.example.shcpcsd.data.api.entities.SensorsListResponse
import com.example.shcpcsd.data.api.entities.SensorsResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface ShcpcsdApi {
    @GET("/sensors")
    suspend fun getSensors(): SensorsResponse
    @GET("/sensors/list")
    suspend fun getSensorsList(): SensorsListResponse


    companion object {
        private const val BASE_URL = "http://84.201.142.1:8080/"
        private val json = Json {
            ignoreUnknownKeys = true
        }

        @OptIn(ExperimentalSerializationApi::class)
        fun create(): ShcpcsdApi {
            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(ShcpcsdApi::class.java)
        }
    }
}