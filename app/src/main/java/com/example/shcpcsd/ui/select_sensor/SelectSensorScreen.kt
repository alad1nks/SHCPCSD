package com.example.shcpcsd.ui.select_sensor

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Compress
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.Sensors
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shcpcsd.ui.entities.SelectedSensor
import com.example.shcpcsd.ui.menu.MenuViewModel
import com.example.shcpcsd.ui.navigation.AppNavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectSensorScreen(
    navController: NavController,
    viewModel: MenuViewModel
) {

    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Выбор датчика",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    Icon(
                        imageVector = Icons.Outlined.Sensors,
                        contentDescription = "Localized description"
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Card(
                onClick = {
                    viewModel.selectSensor(SelectedSensor.TEMPERATURE)
                    navController.navigate(AppNavigationItem.SensorScreen.screenRoute)
                },
                shape = CutCornerShape(0.dp)
            ) {
                ListItem(
                    headlineContent = { Text("Температура") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Thermostat,
                            contentDescription = "Localized description",
                        )
                    }
                )
            }
            Divider()
            Card(
                onClick = {
                    viewModel.selectSensor(SelectedSensor.ILLUMINATION)
                    navController.navigate(AppNavigationItem.SensorScreen.screenRoute)
                },
                shape = CutCornerShape(0.dp)
            ) {
                ListItem(
                    headlineContent = { Text("Освещение") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.WbSunny,
                            contentDescription = "Localized description",
                        )
                    }
                )
            }
            Divider()
            Card(
                onClick = {
                    viewModel.selectSensor(SelectedSensor.PRESSURE)
                    navController.navigate(AppNavigationItem.SensorScreen.screenRoute)
                },
                shape = CutCornerShape(0.dp)
            ) {
                ListItem(
                    headlineContent = { Text("Давление") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Compress,
                            contentDescription = "Localized description",
                        )
                    }
                )
            }
            Divider()
            Card(
                onClick = {
                    viewModel.selectSensor(SelectedSensor.HUMIDITY)
                    navController.navigate(AppNavigationItem.SensorScreen.screenRoute)
                },
                shape = CutCornerShape(0.dp)
            ) {
                ListItem(
                    headlineContent = { Text("Влажность воздуха") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Air,
                            contentDescription = "Localized description",
                        )
                    }
                )
            }
            Divider()
            Card(
                onClick = {
                    viewModel.selectSensor(SelectedSensor.SOIL_MOISTURE)
                    navController.navigate(AppNavigationItem.SensorScreen.screenRoute)
                },
                shape = CutCornerShape(0.dp)
            ) {
                ListItem(
                    headlineContent = { Text("Влажность почвы") },
                    leadingContent = {
                        Icon(
                            Icons.Filled.Grass,
                            contentDescription = "Localized description",
                        )
                    }
                )
            }
            Divider()
        }
    }

}