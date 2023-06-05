package com.example.shcpcsd.ui.menu

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shcpcsd.data.repository.SensorsRepository
import com.example.shcpcsd.ui.entities.SelectedSensor
import com.example.shcpcsd.ui.entities.SensorsUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: SensorsRepository
) : ViewModel() {

    private val _sensors: MutableLiveData<SensorsUi> = MutableLiveData()
    val sensors: LiveData<SensorsUi> get() = _sensors

    private val _selectedSensor: MutableLiveData<SelectedSensor> = MutableLiveData(SelectedSensor.TEMPERATURE)
    private val selectedSensor: LiveData<SelectedSensor> get() = _selectedSensor

    private val _sensorList: MutableLiveData<List<Float>> = MutableLiveData()
    val sensorList: LiveData<List<Float>> get() = _sensorList

    private val _yValues: MutableLiveData<List<Int>> = MutableLiveData()
    val yValues: LiveData<List<Int>> get() = _yValues

    private val _verticalStep: MutableLiveData<Int> = MutableLiveData()
    val verticalStep: LiveData<Int> get() = _verticalStep

    fun selectSensor(sensor: SelectedSensor) {
        _selectedSensor.value = sensor
    }

    fun getSensors() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _sensors.postValue(repository.getSensors())
            } catch (e: IOException) {
            }
        }
    }

    fun getSensorList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val sensorList = repository.getSensorList(sensor = selectedSensor.value!!)
                _sensorList.postValue(sensorList)
            } catch (e: IOException) {
            }
            when (selectedSensor.value!!) {
                SelectedSensor.TEMPERATURE -> {
                    _yValues.postValue(listOf(10, 20, 30, 40))
                    _verticalStep.postValue(10)
                }
                SelectedSensor.ILLUMINATION -> {
                    _yValues.postValue(listOf(50, 100, 150, 200, 250))
                    _verticalStep.postValue(50)
                }
                SelectedSensor.PRESSURE -> {
                    _yValues.postValue(listOf(500, 1000, 1500, 2000, 2500))
                    _verticalStep.postValue(500)
                }
                SelectedSensor.HUMIDITY -> {
                    _yValues.postValue(listOf(20, 40, 60, 80, 100))
                    _verticalStep.postValue(20)
                }

                else -> {
                    _yValues.postValue(listOf(20, 40, 60, 80, 100))
                    _verticalStep.postValue(20)
                }
            }
        }
    }

    private val handler = Handler()
    private val runnable: Runnable = object : Runnable {
        override fun run() {
            getSensors()
            getSensorList()
            handler.postDelayed(this, 5000)
        }

    }
    init {
        handler.postDelayed(runnable, 5000)
    }
}