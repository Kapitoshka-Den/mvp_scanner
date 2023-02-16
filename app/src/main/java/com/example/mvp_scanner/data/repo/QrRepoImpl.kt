package com.example.mvp_scanner.data.repo

import com.example.mvp_scanner.domain.repo.QrRepo
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class QrRepoImpl @Inject constructor(
    private var scanner: GmsBarcodeScanner
) : QrRepo {
    override fun startScanning(): Flow<String?> {
        return callbackFlow {
            scanner.startScan().addOnSuccessListener {
                launch {
                    send(getDetails(it))
                }
            }.addOnFailureListener {
                it.stackTrace
            }
            awaitClose{}
        }

    }

    private fun getDetails(barcode: Barcode): String {
        return "url : ${barcode.rawValue}"

    }
}