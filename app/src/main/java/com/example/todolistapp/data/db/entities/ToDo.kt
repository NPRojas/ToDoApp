package com.example.todolistapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo (
    @ColumnInfo(name = "task") val task: String,
    @ColumnInfo(name = "isComplete") val isComplete: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}