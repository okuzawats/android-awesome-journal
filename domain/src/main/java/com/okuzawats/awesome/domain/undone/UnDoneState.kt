package com.okuzawats.awesome.domain.undone

// TODO data objectに変更する
sealed interface UnDoneState {
  /**
   * 未完了状態
   */
  object ToDo : UnDoneState

  /**
   * 完了状態
   */
  object Done : UnDoneState
}
