package com.example.todolistapp.data.repositories

import com.example.todolistapp.data.db.ToDoDatabase
import com.example.todolistapp.data.db.entities.ToDo

class ToDoRepository(
    private val db: ToDoDatabase
) {
    suspend fun update(item: ToDo) = db.getToDoDao().updateToDo(item)
    suspend fun insert(item: ToDo) = db.getToDoDao().insertToDo(item)
    suspend fun delete(item: ToDo) = db.getToDoDao().deleteToDo(item)

    fun getAllToDos() = db.getToDoDao().getAllToDo()
}