package com.example.mvp_scanner.di.qrModules

import com.example.mvp_scanner.data.respository.QrRepoImpl
import com.example.mvp_scanner.domain.repository.QrRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class QrModule {

    @Binds
    @ViewModelScoped
    abstract fun bindQrRepo(qrRepo: QrRepoImpl): QrRepo

}