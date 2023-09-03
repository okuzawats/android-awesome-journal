package com.okuzawats.awesome.domain.done

// TODO data objectに変更する
sealed interface DoneState {
  /**
   * 未完了状態
   */
  object ToDo : DoneState

  /**
   * 完了状態
   */
  object Done : DoneState
}
