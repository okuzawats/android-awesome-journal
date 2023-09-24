package com.okuzawats.awesome.presenter.daylist.reducer

import com.okuzawats.awesome.presenter.architecture.AwesomeReducer
import com.okuzawats.awesome.presenter.daylist.event.DayListEvent
import com.okuzawats.awesome.presenter.daylist.state.DayListState
import javax.inject.Inject

class DayListReducer @Inject constructor() : AwesomeReducer<DayListState, DayListEvent>(
  initialState = DayListState.Empty,
) {
  override fun reduce(
    oldState: DayListState,
    event: DayListEvent,
  ) {
    when(event) {
      is DayListEvent.DayListLoaded -> {
        setState(
          DayListState.DayList(event.days)
        )
      }
    }
  }
}
