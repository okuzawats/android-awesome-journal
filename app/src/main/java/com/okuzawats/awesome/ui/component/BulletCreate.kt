package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * Bullet作成画面
 */
@Composable
fun BulletCreate(
  message: String,
) {
  Column {
    Text(message)
  }
}
