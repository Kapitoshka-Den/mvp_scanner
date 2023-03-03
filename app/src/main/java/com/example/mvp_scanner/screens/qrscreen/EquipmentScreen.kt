package com.example.mvp_scanner.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mvp_scanner.screens.qrscreen.EquipmentViewModel

@Composable
fun EquipmentScreen (navControl: NavController, equipId: String, viewModel: EquipmentViewModel = hiltViewModel()){

    Text(text = equipId)
    Column() {
        OutlinedTextField(value = "", onValueChange = {}, readOnly = true)
        OutlinedTextField(value = "", onValueChange = {}, readOnly = true)
        OutlinedTextField(value = "", onValueChange = {}, readOnly = true)
        OutlinedTextField(value = "", onValueChange = {}, readOnly = true)
        OutlinedTextField(value = "", onValueChange = {}, readOnly = true)
        OutlinedTextField(value = "", onValueChange = {}, readOnly = true)

    }
}