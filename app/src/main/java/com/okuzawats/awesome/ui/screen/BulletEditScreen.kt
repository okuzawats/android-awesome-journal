package com.okuzawats.awesome.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.okuzawats.awesome.R

/**
 * Bullet作成・編集画面
 *
 * @param bulletId 編集するBulletのID。新規作成の時はnull。
 * @param onDisposed Viewが破棄された時のコールバック
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BulletEditScreen(
  bulletId: String?,
  onBackTapped: () -> Unit,
  onDisposed: () -> Unit,
) {
  DisposableEffect(Unit) {
    onDispose { onDisposed() }
  }

  Column {
    TopAppBar(
      title = {
        // bulletIdがnon-nullなら編集モード、nullなら新規作成モード
        Text(
          stringResource(
            id = if (bulletId != null) R.string.edit_bullet else R.string.create_bullet,
          ),
        )
      },
      navigationIcon = {
        IconButton(onClick = { onBackTapped() }) {
          Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            colorFilter = ColorFilter.tint(Color.Black),
            contentDescription = "pop back", // TODO
            modifier = Modifier.padding(8.dp),
          )
        }
      },
      actions = {
        IconButton(
          onClick = {
            // TODO
            println("Clicked!")
          }
        ) {
          Image(
            painter = painterResource(id = R.drawable.baseline_save_24),
            colorFilter = ColorFilter.tint(Color.Black),
            contentDescription = "save", // TODO
            modifier = Modifier.padding(8.dp),
          )
        }
      },
    )
    // TODO 編集領域を実装する
    Text("test")
  }
}
