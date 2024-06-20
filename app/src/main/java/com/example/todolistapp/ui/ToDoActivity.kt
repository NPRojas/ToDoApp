package com.example.todolistapp.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.R
import com.example.todolistapp.data.db.ToDoDatabase
import com.example.todolistapp.data.db.entities.ToDo
import com.example.todolistapp.data.repositories.ToDoRepository
import com.example.todolistapp.databinding.ActivityToDoBinding
import com.example.todolistapp.other.ToDoItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToDoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_to_do)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // initialize database and repository
        val database = ToDoDatabase(this)
        val repository = ToDoRepository(database)

        val factory = ToDoViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ToDoViewModel::class.java]

        val adapter = ToDoItemAdapter(listOf(), viewModel)
        binding.rvToDoItems.layoutManager = LinearLayoutManager(this)
        binding.rvToDoItems.adapter = adapter

        viewModel.getAllToDoItems().observe(this) {
            adapter.todos = it
            adapter.notifyDataSetChanged()
        }

        // ATTN : Why do I have to find it by Id, shouldnt the id be enough
        val faAddBtn: FloatingActionButton = findViewById(R.id.faAddBtn)

        faAddBtn.setOnClickListener{
            var dialog = AddToDoItemDialog()
            dialog.show(supportFragmentManager, "add to do dialog")
        }

    }
}