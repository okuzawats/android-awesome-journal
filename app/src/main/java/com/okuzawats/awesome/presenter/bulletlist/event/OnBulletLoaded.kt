package com.okuzawats.awesome.presenter.bulletlist.event

import com.okuzawats.awesome.domain.bullet.Bullet

data class OnBulletLoaded(
  val bullets: List<Bullet>,
) : BulletListUiEvent
