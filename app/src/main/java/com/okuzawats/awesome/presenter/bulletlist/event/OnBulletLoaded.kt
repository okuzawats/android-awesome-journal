package com.okuzawats.awesome.presenter.bulletlist.event

import com.okuzawats.awesome.presenter.bulletlist.state.BulletList

/**
 * Bullet一覧の読み込み完了状態
 */
data class OnBulletLoaded(val bulletList: BulletList) : BulletListUiEvent
