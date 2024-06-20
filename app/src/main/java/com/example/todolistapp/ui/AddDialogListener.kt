package com.example.todolistapp.ui

import com.example.todolistapp.data.db.entities.ToDo

interface AddDialogListener {
    fun onAddButtonClicked(toDoItem: ToDo)
}