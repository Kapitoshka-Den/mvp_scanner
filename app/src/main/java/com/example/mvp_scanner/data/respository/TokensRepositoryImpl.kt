package com.example.mvp_scanner.data.respository

import com.example.mvp_scanner.core.model.ResponseException
import com.example.mvp_scanner.domain.models.User
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import com.example.mvp_scanner.domain.repository.TokensRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import javax.inject.Inject

class TokensRepositoryImpl @Inject constructor(
    val client: HttpClient,
    private val dataStoreRepo: DataStoreRepo
) :
    TokensRepository {
    override suspend fun registration(user: User): ResponseException? {
        val response = client.use { client ->
            client.post(BASE_AUTH_URL) {
                setBody(
                    user
                )
            }
        }
        if (response.status == HttpStatusCode.OK) {
            dataStoreRepo.setTokens(response.body())
            return null
        }
        if (response.status == HttpStatusCode.Unauthorized) {
            return ResponseException(HttpStatusCode.Unauthorized,"Not found account")
        }
        return ResponseException(response.status,"server exception")
    }

    override suspend fun authorization(user: User): ResponseException? {
        val response = client.use { client ->
            client.post(BASE_AUTH_URL) {
                setBody(
                    user
                )
            }
        }
        if (response.status == HttpStatusCode.OK) {
            dataStoreRepo.setTokens(response.body())
            return null
        }
        if (response.status == HttpStatusCode.Unauthorized) {
            return ResponseException(HttpStatusCode.Unauthorized,"Not found account")
        }
        return ResponseException(response.status,"server exception")
    }

    override suspend fun changeToken(): ResponseException? {
        val response = client.use { client ->
            client.post(BASE_AUTH_URL) {
                setBody(
                    dataStoreRepo.getRefreshToken
                )
            }
        }
        if (response.status == HttpStatusCode.OK) {
            dataStoreRepo.setTokens(response.body())
            return null
        }
        if (response.status == HttpStatusCode.Unauthorized) {
            return ResponseException(HttpStatusCode.Unauthorized,"Not found account")
        }
        return ResponseException(response.status,"server exception")
    }

    companion object {
        const val BASE_AUTH_URL = ""
    }
}