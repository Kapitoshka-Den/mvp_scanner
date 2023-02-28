package com.example.mvp_scanner.di

import android.content.Context
import androidx.room.Room
import com.example.mvp_scanner.data.database.EquipDataBase
import com.example.mvp_scanner.data.database.bind.BindDao
import com.example.mvp_scanner.data.database.equipment.EquipmentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): EquipDataBase =
        Room.databaseBuilder(
            context.applicationContext,
            EquipDataBase::class.java,
            "equipment_database"
        ).fallbackToDestructiveMigration()
            .build()
    @Provides
    @Singleton
    fun provideEquipment(equipDataBase: EquipDataBase):EquipmentDao = equipDataBase.equipmentDao()

    @Provides
    @Singleton
    fun provideBinds(equipDataBase: EquipDataBase):BindDao = equipDataBase.bindDao()

}