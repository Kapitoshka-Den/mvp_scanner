package com.example.mvp_scanner.domain.repository

import com.example.mvp_scanner.domain.models.Tokens
import kotlinx.coroutines.flow.Flow

interface DataStoreRepo {
    suspend fun setTokens(tokens: Tokens)
    suspend fun getAccesToken(): String
    suspend fun logOut()
    suspend fun getRefreshToken(): String
}
