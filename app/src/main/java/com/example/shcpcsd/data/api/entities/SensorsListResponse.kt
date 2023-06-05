package com.example.shcpcsd.data.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SensorsListResponse(
    @SerialName("result")
    val sensorsList: List<SensorsResponse>
)
