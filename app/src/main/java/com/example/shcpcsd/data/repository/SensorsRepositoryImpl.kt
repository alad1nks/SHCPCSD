package com.example.shcpcsd.data.repository

import android.util.Log
import com.example.shcpcsd.data.api.ShcpcsdApi
import com.example.shcpcsd.data.api.entities.SensorsResponse
import com.example.shcpcsd.ui.entities.SelectedSensor
import com.example.shcpcsd.ui.entities.SensorsUi
import javax.inject.Inject

class SensorsRepositoryImpl @Inject constructor(
    private val api: ShcpcsdApi
) : SensorsRepository {
    override suspend fun getSensors(): SensorsUi {
        return api.getSensors().toSensorsUi()
    }

    override suspend fun getSensorList(sensor: SelectedSensor): List<Float> {
        val sensorList = api.getSensorsList().sensorsList.takeLast(10)
        Log.d("sassassas", sensorList.toString())
        return when (sensor) {
            SelectedSensor.TEMPERATURE -> sensorList.map {
                Log.d("sassassas", it.temperature.toString())
                it.temperature
            }

            SelectedSensor.ILLUMINATION -> sensorList.map {
                it.illumination
            }
            SelectedSensor.PRESSURE -> sensorList.map {
                it.pressure
            }
            SelectedSensor.HUMIDITY -> sensorList.map {
                it.humidity
            }

            else -> sensorList.map {
                it.soilMoisture.toFloat()
            }
        }
    }

    private fun SensorsResponse.toSensorsUi(): SensorsUi {
        return SensorsUi(
            temperature = this.temperature,
            illumination = this.illumination,
            pressure = this.pressure,
            humidity = this.humidity,
            soilMoisture = this.soilMoisture,
            time = this.time
        )
    }
}