package com.example.mvp_scanner.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvp_scanner.data.database.bind.BindDao
import com.example.mvp_scanner.data.database.bind.BindEntity
import com.example.mvp_scanner.data.database.equipment.EquipmentDao
import com.example.mvp_scanner.data.database.equipment.EquipmentEntity


@Database(entities = [EquipmentEntity::class,BindEntity::class], version = 1)
abstract class EquipDataBase : RoomDatabase() {
    abstract fun equipmentDao():EquipmentDao
    abstract fun bindDao(): BindDao
}