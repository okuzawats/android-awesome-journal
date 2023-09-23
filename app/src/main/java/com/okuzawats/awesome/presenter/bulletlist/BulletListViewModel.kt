package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bulletdate.BulletDate
import com.okuzawats.awesome.presenter.bulletlist.event.OnBulletLoaded
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class BulletListViewModel @Inject constructor(
  private val bulletRepository: BulletRepository,
  private val reducer: BulletListReducer,
  private val navigator: BulletListNavigator,
  private val dateProvider: DateProvider,
) : ViewModel() {
  @Composable
  fun present(): BulletListState {
    LaunchedEffect(Unit) {
      // TODO 仮
      val date = dateProvider.today()
      val bullets = bulletRepository.getBulletsAt(
        date = BulletDate(id = UUID.randomUUID(), date = date)
      )
      reducer.sendEvent(
        OnBulletLoaded(
          BulletList(date = date, bullets = bullets)
        )
      )
    }

    return reducer.state.collectAsState().value
  }

  fun onBulletClicked(bullet: Bullet) {
    viewModelScope.launch { navigator.toEdit(bullet = bullet) }
  }
}
