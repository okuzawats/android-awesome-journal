package com.okuzawats.awesome.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.okuzawats.awesome.presenter.bulletlist.BulletListPresenter
import com.okuzawats.awesome.presenter.bulletlist.event.OnBulletClick
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import org.koin.compose.koinInject

/**
 * Bulletを一覧表示するComposable
 */
@Composable
fun BulletList(
    modifier: Modifier = Modifier,
    presenter: BulletListPresenter = koinInject(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
) {
    when (val uiState = presenter.present()) {
        is BulletList -> {
            Column {
                Box(
                    modifier = Modifier
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
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth(),
                ) {
                    items(uiState.count) { i ->
                        BulletListRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            bullet = uiState.bullets[i],
                            onBulletClick = {
                                uiState.eventSink(OnBulletClick)
                            },
                        )
                    }
                }
            }
        }
    }

    DisposableEffect(lifecycleOwner) {
        onDispose {
            presenter.dispose()
        }
    }
}
