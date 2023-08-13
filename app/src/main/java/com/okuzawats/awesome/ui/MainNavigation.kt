package com.okuzawats.awesome.ui

/**
 * 画面遷移を表すinterface
 */
sealed interface MainNavigation {
  /**
   * Bullet一覧画面
   */
  data object BulletList : MainNavigation

  /**
   * Bullet編集画面
   */
  data object BulletEdit : MainNavigation
}
