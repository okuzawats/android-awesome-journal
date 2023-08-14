package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.AwesomePresenter
import com.okuzawats.awesome.presenter.bulletlist.event.OnBulletLoaded
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import java.util.Date

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter(
  private val bulletRepository: BulletRepository,
  private val reducer: BulletListReducer,
  private val navigator: BulletListNavigator,
) : AwesomePresenter<BulletListState>() {
  @Composable
  override fun present(): BulletListState {
    LaunchedEffect(Unit) {
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

  /**
   * Bulletをクリックした時
   */
  fun onBulletClick(bullet: Bullet) {
    launch {
      navigator.toEdit(bullet = bullet)
    }
  }
}
