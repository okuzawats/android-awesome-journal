package com.okuzawats.awesome.domain.done

import kotlinx.coroutines.flow.Flow

/**
 * ToDoの完了状態を完了済みに設定するユースケース
 */
interface DoneToDoUseCase {
  /**
   * ToDoを完了状態として[DoneState.Done]をemitする。
   * ただし、完了状態の保存に失敗した場合はその後[DoneState.ToDo]をemitする。
   */
  suspend operator fun invoke(id: String): Flow<DoneState>
}
