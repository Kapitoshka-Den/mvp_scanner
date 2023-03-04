package com.example.mvp_scanner.domain.models

@kotlinx.serialization.Serializable
data class RegUser(
    val email: String = "",
    val password: String = "",
    val login: String?
)