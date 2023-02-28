package com.example.mvp_scanner.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.screens.MainScreen.MainViewModel

@Composable
fun MainScreen(navHostController: NavHostController,viewModel:MainViewModel = hiltViewModel()) {

val state = viewModel.state.collectAsState()
var scope = rememberCoroutineScope()
    Column() {
        Button(
            onClick = { navHostController.navigate(NavControl.AudienceScreen.route) },
            content = { Text(text = "Учет") })
        Text(text = state.value.requestUrl)
        Button(
            onClick = {
                    viewModel.scann(navHostController)
            },
            content = { Text(text = "Сканирование оборудования") })

    }
}