package com.example.mvp_scanner.domain.apimodels

@kotlinx.serialization.Serializable
data class EquipmentApi(
    val attaches: List<String>,
    val binder: BinderApi,
    val description: String,
    val id: String,
    val model: String,
    val purchaseDate: String,
    val title: String,
    val type: TypeApi
)