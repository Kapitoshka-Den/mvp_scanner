package com.example.mvp_scanner.data.database.equipment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.example.mvp_scanner.data.database.bind.BindEntity

@Entity(
    tableName = EquipmentEntity.EQUIPMENT_TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = BindEntity::class,
        childColumns = [EquipmentEntity.BIND_ID_COLUMN_NAME],
        parentColumns = [BindEntity.ID_COLUMN_NAME],
        onDelete = CASCADE
    )]
)
data class EquipmentEntity(
    @PrimaryKey
    @ColumnInfo(name = ID_COLUMN_NAME)
    val id: String = "",

    @ColumnInfo(name = TITLE_COLUMN_NAME)
    val title: String = "",

    @ColumnInfo(name = BIND_ID_COLUMN_NAME)
    val bindId: String = "",

    val isChecked:Boolean = false
) {
    companion object {
        const val EQUIPMENT_TABLE_NAME = "Equipment_Table"
        const val TITLE_COLUMN_NAME = "Title_Column"
        const val BIND_ID_COLUMN_NAME = "BindId_Column"
        const val ID_COLUMN_NAME = "EquipmentId_Column"
    }
}