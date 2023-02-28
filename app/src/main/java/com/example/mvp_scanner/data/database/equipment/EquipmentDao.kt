package com.example.mvp_scanner.data.database.equipment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EquipmentDao {

    @Insert
    fun insert(equipmentEntity: EquipmentEntity)

    @Query("SELECT * FROM ${EquipmentEntity.EQUIPMENT_TABLE_NAME}")
    fun getAllEquipment():List<EquipmentEntity>


}