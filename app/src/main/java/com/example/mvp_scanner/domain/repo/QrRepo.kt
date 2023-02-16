package com.example.mvp_scanner.domain.repo

import kotlinx.coroutines.flow.Flow

interface QrRepo {
    fun startScanning(): Flow<String?>
}