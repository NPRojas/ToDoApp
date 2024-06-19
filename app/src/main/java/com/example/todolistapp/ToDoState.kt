package com.example.todolistapp

import com.example.todolistapp.data.db.entities.ToDo

data class ToDoState(
    val ToDoList: List<ToDo> = emptyList(),
    val task: String = "",
    val isComplete: Boolean = false,
    val isAddingToDo: Boolean = false
)
