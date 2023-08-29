package com.okuzawats.awesome.ui

/**
 * 画面遷移を表すinterface
 */
sealed interface MainNavigation {
  /**
   * Bullet一覧画面
   */
  object BulletList : MainNavigation

  /**
   * Bullet編集画面
   */
  object BulletEdit : MainNavigation
}
