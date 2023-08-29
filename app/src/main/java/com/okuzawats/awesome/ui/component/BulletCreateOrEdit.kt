package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.res.stringResource
import com.okuzawats.awesome.R

/**
 * Bullet作成・編集画面
 *
 * @param bulletId 編集するBulletのID。新規作成の時はnull。
 * @param onDisposed Viewが破棄された時のコールバック
 */
@Composable
fun BulletCreateOrEdit(
  bulletId: String?,
  onDisposed: () -> Unit,
) {
  DisposableEffect(Unit) {
    onDispose { onDisposed() }
  }

  Column {
    if (bulletId != null) {
      Text(bulletId)
    } else {
      Text(stringResource(id = R.string.create_new))
    }
  }
}
