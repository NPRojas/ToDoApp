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

    @Query("SELECT * FROM ToDo")
    fun getAllToDo(): LiveData<List<ToDo>>

    @Update
    suspend fun updateToDo(toDo: ToDo)

    @Insert
    suspend fun insertToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

}