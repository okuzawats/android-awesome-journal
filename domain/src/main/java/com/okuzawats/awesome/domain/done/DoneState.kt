package com.okuzawats.awesome.domain.done

/**
 * ToDoの完了状態を表す型
 */
sealed interface DoneState {
  /**
   * 未完了状態
   */
  data object ToDo : DoneState

  /**
   * 完了状態
   */
  data object Done : DoneState
}
