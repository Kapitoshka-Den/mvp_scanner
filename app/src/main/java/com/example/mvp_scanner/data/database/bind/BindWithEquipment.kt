package com.example.mvp_scanner.data.database.bind

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mvp_scanner.data.database.equipment.EquipmentEntity


data class BindWithEquipment(
    @Embedded
    val bind: BindEntity,

    @Relation(
        parentColumn = BindEntity.ID_COLUMN_NAME,
        entity = EquipmentEntity::class,
        entityColumn = EquipmentEntity.BIND_ID_COLUMN_NAME
    )
    val equipments: List<EquipmentEntity>
)