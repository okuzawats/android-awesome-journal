package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 戻るボタン付きのTopAppBar
 *
 * @param onBackClicked 戻るボタンがクリックされた時のコールバック
 */
@Composable
fun TopAppBar(onBackClicked: () -> Unit) {
  Row(
    modifier = Modifier.padding(
      vertical = 8.dp,
      horizontal = 16.dp,
    ),
  ) {
    BackButton(onBackClicked = onBackClicked)
  }
}
