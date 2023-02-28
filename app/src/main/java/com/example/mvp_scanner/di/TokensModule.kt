package com.example.mvp_scanner.di

import com.example.mvp_scanner.data.respository.TokensRepositoryImpl
import com.example.mvp_scanner.domain.models.Tokens
import com.example.mvp_scanner.domain.repository.TokensRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class TokensModule {

    @ViewModelScoped
    @Binds
    abstract fun bindTokens(tokens: TokensRepositoryImpl):TokensRepository
}