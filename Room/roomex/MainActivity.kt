package com.example.roomex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.roomex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries()
            .build()

        binding.mainTvResult.text = db.todoDao().getAll().toString()

        binding.mainBtnAdd.setOnClickListener {
            db.todoDao().insert(Todo(binding.mainEdtTodo.text.toString()))
            binding.mainTvResult.text = db.todoDao().getAll().toString()
        }
    }
}