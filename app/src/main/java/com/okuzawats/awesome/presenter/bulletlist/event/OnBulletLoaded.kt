package com.okuzawats.awesome.presenter.bulletlist.event

import com.okuzawats.awesome.presenter.bulletlist.state.BulletList

data class OnBulletLoaded(
  val bulletList: BulletList,
) : BulletListUiEvent
