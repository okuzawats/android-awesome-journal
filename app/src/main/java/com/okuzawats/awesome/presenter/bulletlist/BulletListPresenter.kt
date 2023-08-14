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
) : AwesomePresenter<BulletListState>() {

  @Composable
  override fun present(): BulletListState {
    val date: Date by remember { mutableStateOf(Date()) }
    var bullets: List<Bullet> by remember { mutableStateOf(emptyList()) }

    LaunchedEffect(Unit) {
      bullets = bulletRepository.getBullets()
    }

    return BulletList(
      date = date,
      bullets = bullets,
    ) {
      // TODO 不要な処理なので削除する
      launch {
        bulletRepository.getBullets()
      }
      reducer.sendEvent(it)
    }
  }
}
