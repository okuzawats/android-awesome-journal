package com.okuzawats.awesome.presenter.daylist.event

import com.okuzawats.awesome.presenter.architecture.UiEvent

/**
 * 日付一覧画面のUiEventを表す型
 */
sealed interface DayListEvent : UiEvent {
  /**
   * 日付一覧が読み込まれた
   */
  data class DayListLoaded(val days: List<String>) : DayListEvent
}
