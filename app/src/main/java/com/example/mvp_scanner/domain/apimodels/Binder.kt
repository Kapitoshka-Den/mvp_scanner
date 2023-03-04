package com.example.mvp_scanner.domain.apimodels

@kotlinx.serialization.Serializable
data class BinderApi(
    val audience: AudienceApi,
    val id: String,
    val name: String,
    val user: UserApi
)