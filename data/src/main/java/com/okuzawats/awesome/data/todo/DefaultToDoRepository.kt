package com.okuzawats.awesome.data.todo

import androidx.annotation.VisibleForTesting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultToDoRepository @Inject constructor(
  private val toDoDao: ToDoDao,
) : com.okuzawats.awesome.domain.done.ToDoRepository,
  com.okuzawats.awesome.domain.undone.ToDoRepository {
  override suspend fun doneToDo(id: String): Result<Unit> {
    return withContext(Dispatchers.IO) {
      try {
        val toDo = toDoDao
          .getById(id)
          .copy(isDone = true)
        toDoDao.update(toDo)
        Result.success(Unit)
      } catch (e: Throwable) {
        Result.failure(Throwable("failed to update"))
      }
    }
  }

  override suspend fun unDoneToDo(id: String): Result<Unit> {
    return withContext(Dispatchers.IO) {
      try {
        val toDo = toDoDao
          .getById(id)
          .copy(isDone = false)
        toDoDao.update(toDo)
        Result.success(Unit)
      } catch (e: Throwable) {
        Result.failure(Throwable("failed to update"))
      }
    }
  }

  @VisibleForTesting
  suspend fun getToDoById(id: String): ToDoEntity {
    return withContext(Dispatchers.IO) {
      toDoDao.getById(id)
    }
  }

  @VisibleForTesting
  suspend fun createToDo(
    id: String,
    whatToDo: String,
    isDone: Boolean,
  ) {
    withContext(Dispatchers.IO) {
      val toDo = ToDoEntity(id = id, whatToDo = whatToDo, isDone = isDone)
      toDoDao.create(toDo)
    }
  }
}
