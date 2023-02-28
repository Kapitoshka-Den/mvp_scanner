package com.example.mvp_scanner.domain.repository

import kotlinx.coroutines.flow.Flow

interface QrRepo {
    fun startScanning(): Flow<String?>
}