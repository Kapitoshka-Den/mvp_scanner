package com.example.mvp_scanner.screens.registration

import ValidateTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl

@Composable
fun RegistrationScreen(
    navControl: NavHostController,
    viewModel: RegistrationViewModel = hiltViewModel()
) {

    val state = viewModel.registrationState.collectAsState()
    val errorState = viewModel.errorState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ValidateTextField(
            value = state.value.email,
            onValueChange = { viewModel.changeName(it) },
            label = { Text(text = "email")},
            isError = errorState.value.isError
        )
        ValidateTextField(
            value = state.value.login,
            onValueChange = { viewModel.changeLogin(it) },
            label = { Text(text = "login") },
            isError = errorState.value.isError
        )
        ValidateTextField(
            value = state.value.password,
            onValueChange = { viewModel.changePassword(it) },
            label = { Text(text = "password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = errorState.value.isError,
            errorMessage = errorState.value.errorMessage
        )
        Button(onClick = {viewModel.regClick()}) {
            Text(text = "SignUp")
        }
        Button(onClick = { navControl.popBackStack() }) {
            Text(text = "Back")
        }
    }
}