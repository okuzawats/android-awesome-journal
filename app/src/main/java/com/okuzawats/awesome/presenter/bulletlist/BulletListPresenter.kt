package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import com.slack.circuit.runtime.presenter.Presenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter(
    private val bulletRepository: BulletRepository,
) : Presenter<BulletListState> {
    @Composable
    override fun present(): BulletListState {
        var bullets: List<Bullet> by remember { mutableStateOf(emptyList()) }

        LaunchedEffect(Unit) {
            bullets = bulletRepository.getBullets()
        }

        return BulletList(bullets) {
            // FIXME GlobalScopeを使わないように修正する
            GlobalScope.launch {
                bullets = bulletRepository.getBullets()
            }
        }
    }
}
