package com.example.todolistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.db.entities.ToDo
import com.example.todolistapp.databinding.ItemTodoBinding
import com.example.todolistapp.ui.ToDoViewModel


class ToDoItemAdapter (
    // takes a list of todos
    var todos: List<ToDo>,
    private val viewModel: ToDoViewModel
): RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val curToDoTask = todos[position]
        // is going to bind the to do item data to the text
        holder.binding.apply {
            tvTask.text = curToDoTask.task
            cbTask.isChecked = curToDoTask.isComplete
            // is going to delete the item
            ivDelete.setOnClickListener{
                viewModel.delete(curToDoTask)
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}