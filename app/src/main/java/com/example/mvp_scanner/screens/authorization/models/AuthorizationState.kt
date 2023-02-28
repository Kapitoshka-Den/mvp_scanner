package com.example.mvp_scanner.screens.authorization.models


sealed class AuthorizationState {
    data class errorState(val isError: Boolean = true, val errorMessage: String = "test") :
        AuthorizationState()

    data class authorizationState(val login: String = "", val password: String = "") :
        AuthorizationState()
}