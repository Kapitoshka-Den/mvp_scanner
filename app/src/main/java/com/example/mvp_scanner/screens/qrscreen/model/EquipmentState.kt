package com.example.mvp_scanner.screens.qrscreen.model

import com.example.mvp_scanner.domain.models.Type

data class EquipmentState(
    val binderId: String = "",
    val description: String = "",
    val id: String = "",
    val model: String = "",
    val purchaseDate: String = "",
    val title: String = "",
    val type: String = "",
    val bindTitle :String= ""
)
data class TypeState(
    val id: Int,
    val name: String
)