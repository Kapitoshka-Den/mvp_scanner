package com.example.mvp_scanner.di.repositoryModules

import com.example.mvp_scanner.data.respository.EquipmentRepositoryImpl
import com.example.mvp_scanner.domain.repository.EquipmentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class EquipmentModule {

    @Binds
    @ViewModelScoped
    abstract fun bindEquipmentRepository(equipmentRepository: EquipmentRepositoryImpl):EquipmentRepository
}