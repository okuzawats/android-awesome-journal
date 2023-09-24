package com.okuzawats.awesome.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.okuzawats.awesome.R

@Composable
fun DayListScreen(
  isOpened: Boolean,
  onBackClicked: () -> Unit,
) {
  if (isOpened) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White),
    ) {
      Row(
        modifier = Modifier.padding(vertical = 8.dp),
      ) {
        Spacer(
          modifier = Modifier.width(16.dp),
        )
        IconButton(
          modifier = Modifier.width(48.dp).height(48.dp),
          onClick = { onBackClicked() },
        ) {
          Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "back", // TODO contentDescriptionの設定
            modifier = Modifier.width(24.dp).height(24.dp),
          )
        }
      }
      Text(text = "Day List")
    }
  }
}
