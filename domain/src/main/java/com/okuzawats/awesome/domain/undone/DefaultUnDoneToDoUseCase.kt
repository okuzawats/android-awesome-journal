package com.okuzawats.awesome.domain.undone

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultUnDoneToDoUseCase @Inject constructor(
  private val toDoRepository: ToDoRepository,
) : UnDoneToDoUseCase {
  override suspend fun invoke(id: String): Flow<UnDoneState> {
    return flow {
      // ToDoを未完了状態にする
      emit(UnDoneState.ToDo)

      toDoRepository
        .unDoneToDo(id)
        .onFailure {
          // 保存に失敗したらToDoを完了状態に戻す
          emit(UnDoneState.Done)
        }
    }
  }
}
