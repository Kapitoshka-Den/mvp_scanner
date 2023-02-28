package com.example.mvp_scanner.domain.repository

import com.example.mvp_scanner.domain.models.Tokens
import kotlinx.coroutines.flow.Flow

interface DataStoreRepo {
    suspend fun setTokens(tokens: Tokens)
    val getAccesToken: Flow<String>
    val getRefreshToken: Flow<String>
    suspend fun logOut()
}
