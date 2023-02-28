package com.example.mvp_scanner.domain.repository

import android.media.audiofx.DynamicsProcessing.Eq
import com.example.mvp_scanner.domain.models.Equipment

interface EquipmentRepository {
    suspend fun get(id:String):Equipment
    suspend fun getAll():List<Equipment>
    fun post(body:Equipment)
    fun delete(id: String)
}