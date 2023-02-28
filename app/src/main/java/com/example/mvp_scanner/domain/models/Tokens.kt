package com.example.mvp_scanner.domain.models

@kotlinx.serialization.Serializable
data class Tokens(val accessToken: String = "", val refreshToken: String = "") {
}