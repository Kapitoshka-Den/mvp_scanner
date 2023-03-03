package com.example.mvp_scanner.screens.authorization.models


sealed class AuthorizationState {
    data class errorState(val isError: Boolean = false, val errorMessage: String = "") :
        AuthorizationState()

    data class authorizationState(val login: String = "", val password: String = "") :
        AuthorizationState()
}