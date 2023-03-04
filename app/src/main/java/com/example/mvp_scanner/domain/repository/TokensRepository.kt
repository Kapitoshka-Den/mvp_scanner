package com.example.mvp_scanner.domain.repository

import com.example.mvp_scanner.core.model.ResponseException
import com.example.mvp_scanner.domain.models.AuthUser
import com.example.mvp_scanner.domain.models.RegUser

interface TokensRepository {
    suspend fun registration(user: RegUser): ResponseException?

    suspend fun authorization(user: AuthUser): ResponseException?

    suspend fun changeToken(): ResponseException?
}