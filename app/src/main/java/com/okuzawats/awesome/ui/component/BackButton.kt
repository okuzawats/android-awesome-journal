package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.okuzawats.awesome.R

/**
 * 戻るボタン
 *
 * @param onBackClicked 戻るボタンがクリックされた時のコールバック
 */
@Composable
fun BackButton(onBackClicked: () -> Unit) {
  IconButton(
    modifier = Modifier.size(48.dp),
    onClick = { onBackClicked() },
  ) {
    Icon(
      modifier = Modifier.size(24.dp),
      painter = painterResource(id = R.drawable.baseline_arrow_back_24),
      contentDescription = "back", // TODO contentDescriptionの設定
    )
  }
}
