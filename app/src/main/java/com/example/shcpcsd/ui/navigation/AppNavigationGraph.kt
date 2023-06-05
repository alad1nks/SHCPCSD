package com.example.shcpcsd.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shcpcsd.ui.menu.MenuScreen
import com.example.shcpcsd.ui.menu.MenuViewModel
import com.example.shcpcsd.ui.select_sensor.SelectSensorScreen
import com.example.shcpcsd.ui.sensors.SensorScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigationGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: MenuViewModel = hiltViewModel()
) {
    Scaffold(
        content = {
            NavHost(
                navController = navController,
                startDestination = AppNavigationItem.MenuScreen.screenRoute,
                modifier = Modifier
            ) {
                composable(AppNavigationItem.MenuScreen.screenRoute) {
                    MenuScreen(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                composable(AppNavigationItem.SelectSensorScreen.screenRoute) {
                    SelectSensorScreen(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                composable(AppNavigationItem.SensorScreen.screenRoute) {
                    SensorScreen(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    )
}