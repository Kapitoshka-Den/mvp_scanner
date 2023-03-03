package com.example.mvp_scanner.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthUser(
    val email: String,
    val password: String
)