package com.okuzawats.awesome.domain.undone

import kotlinx.coroutines.flow.Flow

/**
 * ToDoの完了状態を未完了に設定するユースケース
 */
interface UnDoneToDoUseCase {
  /**
   * 未完了状態となった時にfalseをemitする。ただし、完了状態の保存に失敗した場合はその後trueをemitする。
   */
  suspend operator fun invoke(id: Long): Flow<UnDoneState>
}
