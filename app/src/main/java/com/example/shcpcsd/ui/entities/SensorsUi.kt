package com.example.shcpcsd.ui.entities

data class SensorsUi(
    val temperature: Float,
    val illumination: Float,
    val pressure: Float,
    val humidity: Float,
    val soilMoisture: Int,
    val time: String
)
