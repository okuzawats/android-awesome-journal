package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.event.OnBulletLoaded
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class BulletListViewModel @Inject constructor(
  private val bulletRepository: BulletRepository,
  private val reducer: BulletListReducer,
  private val navigator: BulletListNavigator,
) : ViewModel() {
  @Composable
  fun present(): BulletListState {
    LaunchedEffect(Unit) {
      println("===== ${bulletRepository.getBullets()}")
      reducer.sendEvent(
        OnBulletLoaded(
          // TODO 仮
          BulletList(
            date = Date(),
            bullets = bulletRepository.getBullets(),
          )
        )
      )
    }

    return reducer.state.collectAsState().value
  }

  fun onBulletClicked(bullet: Bullet) {
    viewModelScope.launch { navigator.toEdit(bullet = bullet) }
  }
}
