package com.example.mvp_scanner.domain.repository

import com.example.mvp_scanner.domain.models.Bind

interface BindRepository {
    suspend fun getAll():List<Bind>
    suspend fun get(id: String): Bind
}