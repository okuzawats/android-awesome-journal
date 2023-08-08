package com.okuzawats.awesome.presenter.bulletlist.state

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.presenter.bulletlist.event.BulletListUiEvent

/**
 * Bulletの一覧表示
 */
data class BulletList(
    val bullets: List<Bullet>,
    val eventSink: (BulletListUiEvent) -> Unit,
) : BulletListState {
    val count: Int get() = bullets.size
}
