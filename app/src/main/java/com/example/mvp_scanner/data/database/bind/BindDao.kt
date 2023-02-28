package com.example.mvp_scanner.data.database.bind

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.mvp_scanner.domain.models.Bind

@Dao
interface BindDao {

    @Insert
    fun insertBind(entity:BindEntity)

    @Query("SELECT * FROM ${BindEntity.BIND_TABLE_NAME} WHERE ${BindEntity.ID_COLUMN_NAME} == :id")
    fun selectBindById(id:String):BindEntity

    @Transaction @Query("Select * FROM ${BindEntity.BIND_TABLE_NAME} WHERE ${BindEntity.ID_COLUMN_NAME} == :id")
    fun selectWithEquipment(id: String):List<BindWithEquipment>
}