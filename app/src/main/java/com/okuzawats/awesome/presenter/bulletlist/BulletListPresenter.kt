package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.slack.circuit.runtime.presenter.Presenter

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter : Presenter<BulletListState> {
    @Composable
    override fun present(): BulletListState {
        val bullets: List<String> by remember {
            mutableStateOf((10 ..< 100).map { "ABCDEFGHIJKLMNOPQRSTUVWXYZ" })
        }

        return BulletListState.BulletList(bullets) {
            println("on bullet clicked.")
        }
    }
}
