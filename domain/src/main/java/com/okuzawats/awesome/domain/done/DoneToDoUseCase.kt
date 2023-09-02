package com.okuzawats.awesome.domain.done

import kotlinx.coroutines.flow.Flow

/**
 * ToDoの完了状態を完了済みに設定するユースケース
 */
interface DoneToDoUseCase {
  /**
   * 完了状態となった時にtrueをemitする。ただし、完了状態の保存に失敗した場合はその後falseをemitする。
   */
  suspend operator fun invoke(): Flow<Boolean>
}
