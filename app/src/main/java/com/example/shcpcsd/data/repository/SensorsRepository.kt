package com.example.shcpcsd.data.repository

import com.example.shcpcsd.ui.entities.SelectedSensor
import com.example.shcpcsd.ui.entities.SensorsUi

interface SensorsRepository {
    suspend fun getSensors(): SensorsUi
    suspend fun getSensorList(sensor: SelectedSensor): List<Float>
}