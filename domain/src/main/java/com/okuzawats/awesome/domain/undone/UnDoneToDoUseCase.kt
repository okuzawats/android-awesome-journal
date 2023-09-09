package com.okuzawats.awesome.domain.undone

import kotlinx.coroutines.flow.Flow

/**
 * ToDoの完了状態を未完了に設定するユースケース
 */
interface UnDoneToDoUseCase {
  /**
   * ToDoを未完了状態として[UnDoneState.ToDo]をemitする。
   * ただし、完了状態の保存に失敗した場合はその後[UnDoneState.Done]をemitする。
   */
  suspend operator fun invoke(id: String): Flow<UnDoneState>
}
