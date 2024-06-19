package com.example.todolistapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "task") val task: String,
    @ColumnInfo(name = "isComplete") val isComplete: Boolean
)