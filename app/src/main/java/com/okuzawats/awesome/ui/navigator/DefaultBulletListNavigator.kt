package com.okuzawats.awesome.ui.navigator

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class MainNavigator : BulletListNavigator {
  private val _toEdit = MutableSharedFlow<String>()
  val toEdit: Flow<String> get() = _toEdit

  override suspend fun toEdit(bullet: Bullet) {
    _toEdit.emit(bullet.text)
  }
}
