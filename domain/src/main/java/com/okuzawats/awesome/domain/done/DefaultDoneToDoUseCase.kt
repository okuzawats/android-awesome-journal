package com.okuzawats.awesome.domain.done

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultDoneToDoUseCase @Inject constructor(
  private val toDoRepository: ToDoRepository,
) : DoneToDoUseCase {
  override suspend fun invoke(): Flow<Boolean> {
    return flow {
      emit(true) // TODO
      emit(false) // TODO
    }
  }
}
