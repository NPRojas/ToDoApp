package com.example.todolistapp

import com.example.todolistapp.data.db.entities.ToDo

sealed interface ToDoEvent {
    object SaveToDo: ToDoEvent
    data class SetTask(val task: String) : ToDoEvent
    // ATTN Do I really need this since it will always be false initially?
    data class SetIsComplete(val isComplete: Boolean): ToDoEvent
    // ATTN Might delete this later
    object ShowDialog: ToDoEvent
    object HideDialog: ToDoEvent
    data class DeleteToDo(val toDo: ToDo): ToDoEvent
}