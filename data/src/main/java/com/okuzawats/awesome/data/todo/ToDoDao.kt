package com.okuzawats.awesome.data.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * ToDoのDatabase Access Object
 */
@Dao
interface ToDoDao {
  @Query("SELECT * FROM todo")
  fun getAll(): List<ToDoEntity>

  @Query("SELECT * FROM todo WHERE id = :id")
  fun getById(id: String): ToDoEntity

  @Insert
  fun create(toDo: ToDoEntity)

  @Update
  fun update(toDo: ToDoEntity)
}
