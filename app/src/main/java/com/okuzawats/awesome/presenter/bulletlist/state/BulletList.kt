package com.okuzawats.awesome.presenter.bulletlist.state

import com.okuzawats.awesome.domain.bullet.Bullet
import java.util.Date

/**
 * Bulletの一覧表示
 */
data class BulletList(
  val date: Date,
  val bullets: List<Bullet>,
) : BulletListState {
  val count: Int get() = bullets.size
}
