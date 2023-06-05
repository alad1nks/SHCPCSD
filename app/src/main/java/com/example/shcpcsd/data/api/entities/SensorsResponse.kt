package com.example.shcpcsd.data.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SensorsResponse(
    @SerialName("temperature")
    val temperature: Float,
    @SerialName("illumination")
    val illumination: Float,
    @SerialName("pressure")
    val pressure: Float,
    @SerialName("humidity")
    val humidity: Float,
    @SerialName("soilMoisture")
    val soilMoisture: Int,
    @SerialName("time")
    val time: String
)
