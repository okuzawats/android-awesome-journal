package com.okuzawats.awesome.presenter.bulletedit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.okuzawats.awesome.presenter.AwesomePresenter
import com.okuzawats.awesome.presenter.UiState
import com.okuzawats.awesome.presenter.bulletedit.state.BulletEditState
import com.okuzawats.awesome.presenter.bulletedit.state.BulletEditText

class BulletEditPresenter : AwesomePresenter<BulletEditState>() {
  @Composable
  override fun present(): UiState {
    val text: String by remember { mutableStateOf("text") }

    return BulletEditText(text = text)
  }
}
