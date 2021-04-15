package com.example.roomex

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): List<Todo>

    @Insert
    fun insert(vararg todo: Todo)

    @Delete
    fun delete(todo: Todo)

    @Update
    fun update(todo : Todo)
}