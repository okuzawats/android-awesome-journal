package com.okuzawats.awesome.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okuzawats.awesome.data.todo.ToDoDao
import com.okuzawats.awesome.data.todo.ToDoEntity

@Database(entities = [ToDoEntity::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
  abstract fun getToDoDao(): ToDoDao
}
