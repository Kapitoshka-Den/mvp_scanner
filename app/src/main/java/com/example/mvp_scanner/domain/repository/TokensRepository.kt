package com.example.mvp_scanner.domain.repository

import com.example.mvp_scanner.core.model.ResponseException
import com.example.mvp_scanner.domain.models.Tokens
import com.example.mvp_scanner.domain.models.User

interface TokensRepository {
    suspend fun registration(user: User): ResponseException?

    suspend fun authorization(user: User): ResponseException?

    suspend fun changeToken(): ResponseException?
}