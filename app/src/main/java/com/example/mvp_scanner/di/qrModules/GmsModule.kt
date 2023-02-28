package com.example.mvp_scanner.di.qrModules

import android.content.Context
import com.google.android.gms.common.internal.TelemetryLogging.getClient
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning.getClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class GmsModule {

    @ViewModelScoped
    @Provides
    fun provideGmsOptions(): GmsBarcodeScannerOptions {
        return GmsBarcodeScannerOptions
            .Builder()
            .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
            .build()
    }

    @ViewModelScoped
    @Provides
    fun provideGmsScan(context: Context,options: GmsBarcodeScannerOptions):GmsBarcodeScanner{
        return GmsBarcodeScanning.getClient(context,options)
    }

}