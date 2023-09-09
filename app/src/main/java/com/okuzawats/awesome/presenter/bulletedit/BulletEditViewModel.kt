package com.okuzawats.awesome.presenter.bulletedit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bullet.BulletType
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class BulletEditViewModel @Inject constructor(
  private val navigator: BulletEditNavigator,
  private val bulletRepository: BulletRepository,
) : ViewModel() {
  fun onBackClicked() = viewModelScope.launch { navigator.popEdit() }

  fun onSaveClicked() {
    viewModelScope.launch {
      bulletRepository.create(
        bullet = Bullet(
          id = UUID.randomUUID().toString(),
          text = "text",
          type = BulletType.Task,
          done = false,
        )
      )
    }
  }
}
