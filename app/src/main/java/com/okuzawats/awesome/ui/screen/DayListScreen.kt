package com.okuzawats.awesome.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.okuzawats.awesome.presenter.daylist.DayListViewModel
import com.okuzawats.awesome.presenter.daylist.state.DayListState
import com.okuzawats.awesome.ui.component.TopAppBar

/**
 * DrawerMenuから開かれる日付一覧スクリーン
 *
 * FIXME: Drawerを閉じた時にこの画面の一部が消えずに残ってしまうため、[isOpened]で表示を制御している。
 * @param isOpened 自分自身が開かれている時はtrue
 * @param onBackClicked 戻るボタンがクリックされた時のコールバック
 */
@Composable
fun DayListScreen(
  viewModel: DayListViewModel = hiltViewModel(),
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
      TopAppBar(onBackClicked = onBackClicked)

      when (viewModel.present()) {
        is DayListState.DayList -> {
          Text(text = "Day List")
        }
        is DayListState.Empty -> {
          Text(text = "Empty List")
        }
      }
    }
  }
}
