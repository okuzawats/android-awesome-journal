package com.okuzawats.awesome.presenter.daylist.state

import com.okuzawats.awesome.presenter.architecture.UiState

/**
 * 日付一覧画面の状態を表す型
 */
sealed interface DayListState : UiState {
  /**
   * 日付が一件も存在しない状態
   */
  data object Empty : DayListState

  /**
   * 日付のリスト
   *
   * TODO: 型を作成する
   */
  data class DayList(val days: List<String>) : DayListState
}
