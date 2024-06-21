package com.example.todolistapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.todolistapp.data.db.entities.ToDo
import com.example.todolistapp.databinding.DialogAddTodoItemBinding

class AddToDoItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    private lateinit var binding: DialogAddTodoItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogAddTodoItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener{
            // Get the values from the dialog to create the to do object
            val task = binding.etTask.text.toString()
            val isComplete = false

            if(task.isEmpty()) {
                Toast.makeText(context, "Please enter a task to add to the list", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create to do item
            val toDoItem = ToDo(task, isComplete)

            // Notify Listener
            addDialogListener.onAddButtonClicked(toDoItem)

            dismiss()
        }

        binding.btnCancel.setOnClickListener{
            dismiss()
        }
    }
}