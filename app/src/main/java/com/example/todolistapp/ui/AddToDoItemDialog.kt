package com.example.todolistapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.todolistapp.R
import com.example.todolistapp.data.db.entities.ToDo
import com.example.todolistapp.databinding.DialogAddTodoItemBinding


class AddToDoItemDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.dialog_add_todo_item, container, false)
        return rootView
    }
}

