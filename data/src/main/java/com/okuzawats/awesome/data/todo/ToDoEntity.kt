package com.okuzawats.awesome.data.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ToDoを表すEntity
 */
@Entity(tableName = "todo")
data class ToDoEntity(
  @PrimaryKey
  @ColumnInfo(name = "id")
  val id: String,

  @ColumnInfo(name = "what_to_do")
  val whatToDo: String,

  @ColumnInfo(name = "is_done")
  val isDone: Boolean,
)
