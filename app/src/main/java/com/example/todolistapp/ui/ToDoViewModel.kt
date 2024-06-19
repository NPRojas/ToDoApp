package com.example.todolistapp.ui

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.db.entities.ToDo
import com.example.todolistapp.data.repositories.ToDoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(
    private val repository: ToDoRepository
) : ViewModel()  {

    fun update(item: ToDo) = CoroutineScope(Dispatchers.Main).launch {
        repository.update(item)
    }

    fun insert(item: ToDo) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ToDo) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllToDoItems() = repository.getAllToDos()
}