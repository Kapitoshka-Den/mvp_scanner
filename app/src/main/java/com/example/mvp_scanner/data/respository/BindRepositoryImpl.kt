package com.example.mvp_scanner.data.respository

import com.example.mvp_scanner.domain.models.Bind
import com.example.mvp_scanner.domain.repository.BindRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class BindRepositoryImpl @Inject constructor(val client: HttpClient) : BindRepository {
    override suspend fun get(id:String): Bind {
        return client.use { client -> client.get("$BASE_URL_BIND/$id").body() }
    }

    override suspend fun getAll(): List<Bind> {
        return  client.use { client -> client.get(BASE_URL_BIND).body() }
    }

    companion object{
        const val BASE_URL_BIND = ""
    }
}