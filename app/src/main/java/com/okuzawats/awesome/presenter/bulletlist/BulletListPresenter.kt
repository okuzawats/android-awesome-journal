package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.okuzawats.awesome.presenter.AwesomePresenter
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.Date

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter(
    private val bulletRepository: BulletRepository,
) : AwesomePresenter<BulletListState>, CoroutineScope {
    @Composable
    override fun present(): BulletListState {
        var date: Date by remember { mutableStateOf(Date()) }
        var bullets: List<Bullet> by remember { mutableStateOf(emptyList()) }

        LaunchedEffect(Unit) {
            bullets = bulletRepository.getBullets()
        }

        return BulletList(
            date = date,
            bullets = bullets,
        ) {
            launch {
                bullets = bulletRepository.getBullets()
            }
        }
    }

    override fun dispose() {
        // FIXME Jobがない場合にIllegalStateExceptionを吐いてしまうため、要修正
        // cancel()
    }
}
