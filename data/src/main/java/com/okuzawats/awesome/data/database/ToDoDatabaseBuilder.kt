package com.okuzawats.awesome.data.database

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ToDoDatabaseBuilder @Inject constructor(
  @ApplicationContext
  private val context: Context,
) {
  fun build(): ToDoDatabase {
    return Room
      .databaseBuilder(
        context = context,
        klass = ToDoDatabase::class.java,
        name = "todo_database",
      )
      .build()
  }
}
