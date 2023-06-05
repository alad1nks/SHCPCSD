package com.example.shcpcsd.ui.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Sensors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shcpcsd.ui.entities.SensorsUi
import com.example.shcpcsd.ui.navigation.AppNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navController: NavController,
    viewModel: MenuViewModel
) {
    val sensors by viewModel.sensors.observeAsState(
        SensorsUi(
            0f, 0f, 0f, 0f, 0, ""
        )
    )
    viewModel.getSensors()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "SHCPCSD",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
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
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Показатели:",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Температура: ${sensors.temperature}°C",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Освещение: ${sensors.illumination} lx",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Давление: ${sensors.pressure} hPa",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Влажность воздуха: ${sensors.humidity} %",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Влажность почвы: ${sensors.soilMoisture} %",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Советы:",
                modifier = Modifier.padding(top = 16.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            if (sensors.temperature >= 35f) {
                Text(
                    text = "Слишком жарко! Переставьте растение в более прохладное место"
                )
            } else if (sensors.temperature <= 15f) {
                Text(
                    text = "Слишком холодно! Переставьте растение в более тёплое место"
                )
            }

            if (sensors.illumination >= 250f) {
                Text(
                    text = "Слишком ярко! Переставьте растение в более тёмное место",
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else if (sensors.illumination <= 30f) {
                Text(
                    text = "Слишком темно! Переставьте растение в более солнечное место",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            if (sensors.pressure >= 2500f) {
                Text(
                    text = "Слишком высокое давление!",
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else if (sensors.pressure <= 50f) {
                Text(
                    text = "Низкое давление!",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            if (sensors.humidity >= 85f) {
                Text(
                    text = "Воздух слишком влажный! Переставьте растение в более сухое место",
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else if (sensors.humidity <= 30f) {
                Text(
                    text = "Воздух слишком сухой! Переставьте растение в более влажное место",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            if (sensors.soilMoisture >= 35f) {
                Text(
                    text = "Почва слишком влажная! Уберите лишнюю влагу",
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else if (sensors.soilMoisture <= 15f) {
                Text(
                    text = "Почва слишком сухая! Полейте растение",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            FilledIconButton(
                onClick = {
                    navController.navigate(AppNavigationItem.SelectSensorScreen.screenRoute)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, end = 16.dp),
                content = {
                    Text(
                        text = "Выбор датчика",
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                    )
                }
            )
        }
    }
}