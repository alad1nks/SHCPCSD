package com.example.shcpcsd.ui.navigation

sealed class AppNavigationItem(var screenRoute: String) {
    object MenuScreen : AppNavigationItem("menu")
    object SelectSensorScreen : AppNavigationItem("select_sensor")
    object SensorScreen : AppNavigationItem("sensor")
}
