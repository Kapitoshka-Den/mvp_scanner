package com.example.mvp_scanner.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    val attaches: List<String>,
    val binderId: String,
    val description: String,
    val id: String,
    val model: String,
    val purchaseDate: String,
    val title: String,
    val type: Type
)