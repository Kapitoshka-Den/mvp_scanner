package com.example.mvp_scanner.screens.authorization

import ValidateTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mvp_scanner.NavControl


@Composable
fun AuthorizationScreen(
    navControl: NavHostController,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {
    val state = viewModel.authorizationState.collectAsState()
    val errorState = viewModel.errorState.collectAsState()
    LaunchedEffect(state){
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ValidateTextField(
            value = state.value.login,
            onValueChange = { viewModel.changeLogin(it) },
            label = { Text(text ="email") },
            isError = errorState.value.isError,
        )
        ValidateTextField(
            value = state.value.password,
            onValueChange = { viewModel.changePassword(it) },
            label = { Text(text = "password")},
            isError = errorState.value.isError,
            errorMessage = errorState.value.errorMessage,
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {
            viewModel.authorizeClick(navControl)

        }) {
            Text(text = "SignIn")
        }
        Button(onClick = {
            navControl.navigate(NavControl.RegistrationScreen.route) {
                restoreState = true
                launchSingleTop = true
            }
        }) {
            Text(text = "SignUp")
        }
    }
}

