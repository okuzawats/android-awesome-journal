package com.okuzawats.awesome.domain.done

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultDoneToDoUseCase @Inject constructor(
  private val toDoRepository: ToDoRepository,
) : DoneToDoUseCase {
  override suspend fun invoke(id: Long): Flow<DoneState> {
    return flow {
      // ToDoを完了状態にする
      emit(DoneState.Done)

      toDoRepository
        .doneToDo(id)
        .onFailure {
          // 保存に失敗したらToDoを未完了状態に戻す
          emit(DoneState.ToDo)
        }
    }
  }
}
