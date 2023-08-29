package com.okuzawats.awesome.presenter.bulletlist.reducer

import com.okuzawats.awesome.presenter.architecture.AwesomeReducer
import com.okuzawats.awesome.presenter.bulletlist.event.BulletListUiEvent
import com.okuzawats.awesome.presenter.bulletlist.event.OnBulletLoaded
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListInitial
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

/**
 * Bullet一覧画面の状態を更新するためのReducer
 */
class BulletListReducer @Inject constructor() : AwesomeReducer<BulletListState, BulletListUiEvent>(
  initialState = BulletListInitial,
) {
  override fun reduce(oldState: BulletListState, event: BulletListUiEvent) {
    when (event) {
      is OnBulletLoaded -> {
        // TODO UiEventからデータを受け取るように修正
        val calendar = Calendar.getInstance()
        calendar.time = if (oldState is BulletList) oldState.date else Date()
        calendar.add(Calendar.DATE, 1)
        val newDate = calendar.time

        setState(
          BulletList(
            date = newDate,
            bullets = event.bulletList.bullets,
          )
        )
      }
    }
  }
}
