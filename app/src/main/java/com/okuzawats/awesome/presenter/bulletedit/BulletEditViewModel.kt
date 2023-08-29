package com.okuzawats.awesome.presenter.bulletedit

import androidx.lifecycle.ViewModel
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BulletEditViewModel @Inject constructor(
  private val navigator: BulletEditNavigator,
) : ViewModel() {
  fun onBackClicked() {}

  fun onSaveClicked() {}
}
