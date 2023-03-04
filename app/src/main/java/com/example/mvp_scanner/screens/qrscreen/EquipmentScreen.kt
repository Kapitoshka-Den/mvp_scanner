package com.example.mvp_scanner.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mvp_scanner.screens.qrscreen.EquipmentViewModel

@Composable
fun EquipmentScreen(
    navControl: NavController,
    equipId: String,
    viewModel: EquipmentViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsState()

    LaunchedEffect(equipId) {
        viewModel.changeId(equipId)
    }

    Column(modifier = Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
        Text(text = "Информация по вашему оборудованию")
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            label = { Text(text ="Название") },
            value = state.value.title,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.padding(5.dp)
        )
        OutlinedTextField(
            label = { Text(text ="Модель") },
            value = state.value.model,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.padding(5.dp)
        )
        OutlinedTextField(
            label = { Text(text ="Описание") },
            value = state.value.description,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.padding(5.dp)
        )
        OutlinedTextField(
            label = { Text(text ="Дата закупки") },
            value = state.value.purchaseDate,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.padding(5.dp)
        )
        OutlinedTextField(
            label = { Text(text ="Тип оборудования") },
            value = state.value.type,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.padding(5.dp)
        )
        OutlinedTextField(
            label = { Text(text ="Где находиться") },
            value = state.value.bindTitle,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.padding(5.dp)
        )

    }
}