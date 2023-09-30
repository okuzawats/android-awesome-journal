package com.okuzawats.awesome.presenter.daylist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import com.okuzawats.awesome.presenter.daylist.event.DayListEvent
import com.okuzawats.awesome.presenter.daylist.reducer.DayListReducer
import com.okuzawats.awesome.presenter.daylist.state.DayListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DayListViewModel @Inject constructor(
  private val bulletDateRepository: BulletDateRepository,
  private val dayListReducer: DayListReducer,
) : ViewModel() {
  @Composable
  fun present(): DayListState {
    LaunchedEffect(Unit) {
      val days = bulletDateRepository.getAll()
      dayListReducer.sendEvent(
        DayListEvent.DayListLoaded(days.map { it.date.toString() }) // TODO 仮
      )
    }

    return dayListReducer.state.collectAsState().value
  }
}
