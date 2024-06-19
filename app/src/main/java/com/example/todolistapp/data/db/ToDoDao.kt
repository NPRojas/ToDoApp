package com.example.todolistapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolistapp.data.db.entities.ToDo

@Dao
interface ToDoDao {
    // ATTN Do I need to change this to only get the task instead of all info?
    @Query("SELECT * FROM ToDo")
    fun getAllToDo(): LiveData<List<ToDo>>

    // ATTN not sure if this is right?
    @Update
    suspend fun updateToDo(toDo: ToDo)

    @Insert
    suspend fun insertToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

}