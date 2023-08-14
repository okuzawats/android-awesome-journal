package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Bullet作成・編集画面
 *
 * @param bulletId 編集するBulletのID。新規作成の時はnull。
 */
@Composable
fun BulletCreate(
  bulletId: String?,
) {
  Column {
    if (bulletId != null) {
      Text(bulletId)
    } else {
      Text("新規作成")
    }
  }
}
