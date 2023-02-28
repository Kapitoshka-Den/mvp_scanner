package com.example.mvp_scanner.data.respository

import com.example.mvp_scanner.domain.models.Equipment
import com.example.mvp_scanner.domain.repository.EquipmentRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject


class EquipmentRepositoryImpl @Inject constructor(private val client: HttpClient) : EquipmentRepository {
    override suspend fun get(id: String): Equipment {
        return client.get("$BASE_URL_EQUIPMENT/$id").body()
    }

    override suspend fun getAll(): List<Equipment>{
        return client.get(BASE_URL_EQUIPMENT).body()
    }

    override fun post(body: Equipment) {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    companion object {
        const val BASE_URL_EQUIPMENT: String = ""
    }
}