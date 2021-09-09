package com.taskone.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyDbModel {
    @PrimaryKey(autoGenerate = true)
    var uid = 0

    @ColumnInfo(name = "json_string")
    var jsonString: String? = null

    @ColumnInfo(name = "created_at")
    var createdAt: String? = null

}