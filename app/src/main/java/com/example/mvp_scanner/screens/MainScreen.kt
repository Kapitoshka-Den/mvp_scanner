package com.example.mvp_scanner.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl

@Composable
fun MainScreen(navHostController: NavHostController) {
    Column() {
        Button(
            onClick = { navHostController.navigate(NavControl.AudienceScreen.route) },
            content = { Text(text = "Учет") })
        Button(
            onClick = { navHostController.navigate(NavControl.EquipmentScreen.route) },
            content = { Text(text = "Проверка ифнормации по оборудованию") })

    }
}