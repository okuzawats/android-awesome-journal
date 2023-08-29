package com.okuzawats.awesome.presenter.bulletedit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.okuzawats.awesome.presenter.architecture.AwesomePresenter
import com.okuzawats.awesome.presenter.architecture.UiState
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import com.okuzawats.awesome.presenter.bulletedit.state.BulletEditState
import com.okuzawats.awesome.presenter.bulletedit.state.BulletEditText

class BulletEditPresenter(
  private val navigator: BulletEditNavigator,
) : AwesomePresenter<BulletEditState>() {
  @Composable
  override fun present(): UiState {
    val text: String by remember { mutableStateOf("text") }

    return BulletEditText(text = text)
  }

  fun onSaveClicked() {
    println("on save clicked!")
  }
}
