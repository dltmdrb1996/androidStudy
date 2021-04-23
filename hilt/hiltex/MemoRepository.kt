package com.example.hiltex

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomex.Todo
import javax.inject.Inject

class MemoRepository @Inject constructor(private val db : MemoDatabase){
    fun getAll(){
        db.todoDao().getAll()
    }

    fun insert(){
        db.todoDao().insert()
    }

    fun delete(todo: Todo){
        db.todoDao().delete(todo)
    }

    fun update(todo: Todo){
        db.todoDao().update(todo)
    }

    fun nukeTable(){
        db.todoDao().nukeTable()
    }
}
