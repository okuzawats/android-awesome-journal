package com.okuzawats.awesome.presenter.bulletlist

import java.util.Date

/**
 * [Date]を提供するための型
 */
fun interface DateProvider {
  /**
   * 実行時の日付の[Date]型を返す
   */
  fun today(): Date
}
