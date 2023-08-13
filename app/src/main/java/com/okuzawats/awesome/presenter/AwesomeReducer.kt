package com.okuzawats.awesome.presenter

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * [UiState] [UiEvent]の状態更新を行う。
 *
 * @param S UIの状態を表す型
 * @param E UIで発生するイベントを表す型
 */
abstract class AwesomeReducer<S: UiState, E : UiEvent>(initialState: S) {

  private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)

  /**
   * UIの状態
   */
  val state: StateFlow<S> get() = _state

  private val _event: MutableSharedFlow<E> = MutableSharedFlow()

  /**
   * 状態を更新する
   */
  fun setState(s: S) {
    _state.tryEmit(s)
  }

  /**
   * イベントを発行する
   */
  fun sendEvent(e: E) {
    reduce(_state.value, e)
  }

  /**
   * [oldState]の状態から新たな状態を作り出すための抽象関数
   *
   * 本抽象関数をoverrideして、[oldState]と[event]から新たな状態に更新する処理を実装すること。
   * @param oldState 現在の[state]の値
   * @param event UIで発生したイベント
   */
  abstract fun reduce(oldState: S, event: E)
}
