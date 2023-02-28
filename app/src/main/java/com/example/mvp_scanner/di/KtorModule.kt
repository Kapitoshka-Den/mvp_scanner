package com.example.mvp_scanner.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class KtorModule {

    @Provides
    @Singleton
    fun provideClient():HttpClient{
        return HttpClient(CIO){
            install(ContentNegotiation){
                json()
            }
        }
    }
}