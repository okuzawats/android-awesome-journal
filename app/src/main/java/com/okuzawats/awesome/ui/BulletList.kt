package com.okuzawats.awesome.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.okuzawats.awesome.presenter.bulletlist.BulletListPresenter
import com.okuzawats.awesome.presenter.bulletlist.BulletListState
import org.koin.compose.koinInject

/**
 * Bulletを一覧表示するComposable
 */
@Composable
fun BulletList(
    modifier: Modifier = Modifier,
    presenter: BulletListPresenter = koinInject(),
) {
    when (val uiState = presenter.present()) {
        is BulletListState.BulletList -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
            ) {
                items(uiState.count) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .clip(shape = RoundedCornerShape(4.dp))
                            .background(color = Color.White),
                    ) {
                        Text(
                            text = uiState.bullets[it],
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 8.dp),
                        )
                    }
                }
            }
        }
    }
}
