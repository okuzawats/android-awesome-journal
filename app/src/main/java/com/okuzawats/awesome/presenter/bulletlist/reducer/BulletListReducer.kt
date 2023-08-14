package com.okuzawats.awesome.presenter.bulletlist.reducer

import com.okuzawats.awesome.presenter.AwesomeReducer
import com.okuzawats.awesome.presenter.bulletlist.event.BulletListUiEvent
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListInitial
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState

/**
 * Bullet一覧画面の状態を更新するためのReducer
 */
class BulletListReducer : AwesomeReducer<BulletListState, BulletListUiEvent>(
  initialState = BulletListInitial,
) {
  override fun reduce(
    oldState: BulletListState,
    event: BulletListUiEvent,
  ) {
    when (oldState) {
      is BulletListInitial -> {
        // TODO
      }

      is BulletList -> {
        val newState = oldState.bullets.reversed()
        setState(
          BulletList(
            date = oldState.date,
            bullets = newState,
            eventSink = oldState.eventSink,
          )
        )
      }
    }
  }
}
