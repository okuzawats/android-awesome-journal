package com.okuzawats.awesome.domain.undone

/**
 * ToDoの未完了状態を表す型
 */
sealed interface UnDoneState {
  /**
   * 未完了状態
   */
  data object ToDo : UnDoneState

  /**
   * 完了状態
   */
  data object Done : UnDoneState
}
