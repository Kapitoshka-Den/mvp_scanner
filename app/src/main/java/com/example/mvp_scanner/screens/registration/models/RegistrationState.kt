package com.example.mvp_scanner.screens.registration.models

sealed class RegistrationState() {
    data class errorState(val isError: Boolean = false, val errorMessage: String = "")
    data class registrationState(
        val email: String = "",
        val login: String = "",
        val password: String = ""
    )
}