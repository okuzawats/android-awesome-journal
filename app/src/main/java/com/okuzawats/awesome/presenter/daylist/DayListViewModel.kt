package com.okuzawats.awesome.presenter.daylist

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import com.okuzawats.awesome.presenter.daylist.state.DayListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DayListViewModel @Inject constructor(
  private val bulletDateRepository: BulletDateRepository,
) : ViewModel() {
  @Composable
  fun present(): DayListState {
    return DayListState.Empty
  }
}
