package com.example.mvp_scanner.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl
import com.example.mvp_scanner.screens.MainScreen.MainViewModel

@Composable
fun MainScreen(navHostController: NavHostController,viewModel:MainViewModel = hiltViewModel()) {

val state = viewModel.state.collectAsState()
var scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
        Button(
            onClick = { navHostController.navigate(NavControl.AudienceScreen.route) },
            content = { Text(text = "Учет") })
        Button(
            onClick = {
                    viewModel.scann(navHostController)
            },
            content = { Text(text = "Сканирование оборудования") })

    }
}