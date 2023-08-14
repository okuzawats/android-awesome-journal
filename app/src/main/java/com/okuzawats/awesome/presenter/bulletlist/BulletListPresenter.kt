package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.AwesomePresenter
import com.okuzawats.awesome.presenter.bulletlist.event.OnBulletLoaded
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListInitial
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Date

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter(
  private val bulletRepository: BulletRepository,
  private val reducer: BulletListReducer,
) : AwesomePresenter<BulletListState>() {
  @Composable
  override fun present(): BulletListState {
    var date: Date by remember { mutableStateOf(Date()) }
    var bullets: List<Bullet> by remember { mutableStateOf(emptyList()) }

    LaunchedEffect(Unit) {
      reducer.sendEvent(
        OnBulletLoaded(
          bulletRepository.getBullets(),
        ),
      )
    }
    
    // TODO collectとstateの更新を行う処理を親クラスでできないか検討する。
    launch {
      reducer
        .state
        .collect {
          when (it) {
            is BulletListInitial -> {
              // TODO
            }
            is BulletList -> {
              date = it.date
              bullets = it.bullets
            }
          }
        }
    }

    return BulletList(
      date = date,
      bullets = bullets,
    ) {
      // TODO View-Presenter | Presenter-Reducerのイベントを分ける。
      launch {
        reducer.sendEvent(
          OnBulletLoaded(
            bulletRepository.getBullets(),
          ),
        )
      }
    }
  }
}
