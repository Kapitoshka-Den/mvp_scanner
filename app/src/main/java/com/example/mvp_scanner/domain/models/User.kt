package com.example.mvp_scanner.domain.models

@kotlinx.serialization.Serializable
data class User(
    val email: String = "",
    val password: String = "",
    val login: String?
)