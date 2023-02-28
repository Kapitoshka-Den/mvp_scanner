package com.example.mvp_scanner.di

import android.content.Context
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.mvp_scanner.data.respository.DataStoreRepoImpl
import com.example.mvp_scanner.domain.repository.DataStoreRepo
import dagger.Provides
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Provides
    @Singleton
    fun bindsDataStore(context: Context): DataStoreRepo{
        return DataStoreRepoImpl(context)
    }
}


