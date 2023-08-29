package com.okuzawats.awesome.ui.navigator

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * 全体の画面遷移の実装クラス
 */
class MainNavigator : BulletEditNavigator, BulletListNavigator {
  /**
   * 編集画面への画面遷移イベント
   */
  val toEdit: Flow<Bullet> get() = _toEdit
  private val _toEdit = MutableSharedFlow<Bullet>()

  val pop: Flow<Unit> get() = _pop
  private val _pop = MutableSharedFlow<Unit>()

  override suspend fun popEdit() { _pop.emit(Unit) }

  /** BulletListNavigator */
  override suspend fun toEdit(bullet: Bullet) { _toEdit.emit(bullet) }
}
