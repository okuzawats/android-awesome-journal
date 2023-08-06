package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import com.slack.circuit.runtime.presenter.Presenter

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter(
    private val bulletRepository: BulletRepository,
) : Presenter<BulletListState> {
    @Composable
    override fun present(): BulletListState {
        val bullets: List<String> by remember {
            mutableStateOf((10 ..< 100).map { "ABCDEFGHIJKLMNOPQRSTUVWXYZ" })
        }

        return BulletList(bullets) {
            println("on bullet clicked.")
        }
    }
}
