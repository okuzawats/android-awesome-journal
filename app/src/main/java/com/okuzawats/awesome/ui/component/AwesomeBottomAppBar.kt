package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.okuzawats.awesome.R

/**
 * アプリ内で使用するBottomAppBar
 *
 * @param onFabClicked FABタップ時に発火するLambda
 */
@Composable
fun AwesomeBottomAppBar(
  modifier: Modifier = Modifier,
  onCalendarClicked: () -> Unit,
  onFabClicked: () -> Unit,
) {
  // FIXME BottomAppBarの引数にActionとFABを渡すように修正する。
  //  現在、上記のコードがビルドエラーとってしまうため、自力で配置する。
  BottomAppBar {
    Row(modifier = modifier.padding(top = 12.dp, end = 16.dp, bottom = 12.dp)) {
      Spacer(modifier = Modifier
        .width(4.dp),
      )
      IconButton(
        modifier = Modifier
          .width(48.dp)
          .height(48.dp),
        onClick = { onCalendarClicked() },
      ) {
        Icon(
          painter = painterResource(id = R.drawable.baseline_calendar_month_24),
          contentDescription = "calendar", // TODO contentDescriptionの設定
          modifier = Modifier
            .width(24.dp)
            .height(24.dp),
        )
      }
      // FABをRowの末尾に配置するためのSpacer
      Spacer(modifier = Modifier
        .weight(1f)
        .fillMaxHeight())
      FloatingActionButton(onClick = onFabClicked) {
        Icon(
          painter = painterResource(id = R.drawable.baseline_add_24),
          contentDescription = "add", // TODO contentDescriptionの設定
          modifier = Modifier
            .width(24.dp)
            .height(24.dp),
        )
      }
    }
  }
}
