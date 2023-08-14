package com.okuzawats.awesome.presenter.bulletlist.navigator

import com.okuzawats.awesome.domain.bullet.Bullet

/**
 * Bullet一覧画面の画面遷移を行うためのinterface
 */
interface BulletListNavigator {
  /**
   * 編集画面への遷移
   *
   * @param bullet 編集の対象となるBullet
   */
  suspend fun toEdit(bullet: Bullet)
}
