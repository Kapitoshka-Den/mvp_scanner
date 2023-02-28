package com.example.mvp_scanner.di.repositoryModules

import com.example.mvp_scanner.data.respository.BindRepositoryImpl
import com.example.mvp_scanner.domain.repository.BindRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class BindModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBind(bindRepository: BindRepositoryImpl):BindRepository
}