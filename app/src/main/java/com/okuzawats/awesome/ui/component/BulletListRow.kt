package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.okuzawats.awesome.R
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletType

/**
 * Bullet 1つを表示するComposable
 *
 * @param bullet 表示するBullet
 * @param onBulletClick Bullet 1つがタップされた時に発火するイベント
 */
@Composable
fun BulletListRow(
  modifier: Modifier = Modifier,
  bullet: Bullet,
  onBulletClick: (Bullet) -> Unit,
) {
  Column {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = modifier.clickable(onClick = { onBulletClick(bullet) }),
    ) {
      Spacer(modifier = Modifier.width(16.dp))
      Image(
        painter = painterResource(id = R.drawable.baseline_check_circle_outline_24),
        colorFilter = ColorFilter.tint(Color.Black),
        contentDescription = "task not checked", // TODO
        modifier = Modifier.width(24.dp).height(24.dp),
      )
      Spacer(modifier = Modifier.width(16.dp))
      Text(
        text = bullet.text,
        modifier = Modifier.padding(all = 8.dp),
      )
      Spacer(modifier = Modifier.width(24.dp))
    }
    Divider(
      color = MaterialTheme.colorScheme.outlineVariant,
      modifier = Modifier.fillMaxWidth().height(1.dp),
    )
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun BulletListRow_withText() {
  BulletListRow(
    bullet = Bullet(id = "random-uuid-123456", text = "text", type = BulletType.Task, done = false),
    onBulletClick = {},
  )
}
