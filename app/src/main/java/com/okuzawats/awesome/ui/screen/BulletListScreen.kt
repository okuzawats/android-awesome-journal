package com.okuzawats.awesome.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.okuzawats.awesome.presenter.bulletlist.BulletListViewModel
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListInitial
import com.okuzawats.awesome.ui.component.BulletListRow

/**
 * Bulletを一覧表示するComposable
 */
@Composable
fun BulletListScreen(
  viewModel: BulletListViewModel = hiltViewModel(),
) {
  when (val uiState = viewModel.present()) {
    is BulletListInitial -> {
      // TODO
    }
    is BulletList -> {
      Column {
        Box(modifier = Modifier
          .fillMaxWidth()
          .height(56.dp)
          .padding(16.dp),
        ) {
          Text(
            // TODO formatterを適用する
            text = uiState.date.toString(),
            modifier = Modifier
              .align(Alignment.Center)
              .fillMaxWidth(),
          )
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
          items(uiState.count) { i ->
            BulletListRow(
              modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
              bullet = uiState.bullets[i],
              onBulletClick = { viewModel.onBulletClicked(it) },
            )
          }
        }
      }
    }
  }
}
