package com.example.mvp_scanner.data.database.bind

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BindEntity.BIND_TABLE_NAME)
data class BindEntity(
    @PrimaryKey
    @ColumnInfo(name = ID_COLUMN_NAME)
    val bindId: String = "",

    @ColumnInfo(name = NAME_COLUMN_NAME)
    val name: String = ""

) {
    companion object {
        const val BIND_TABLE_NAME = "Bind_Table"
        const val NAME_COLUMN_NAME = "Name_Column"
        const val ID_COLUMN_NAME = "BindId_Column"
    }
}