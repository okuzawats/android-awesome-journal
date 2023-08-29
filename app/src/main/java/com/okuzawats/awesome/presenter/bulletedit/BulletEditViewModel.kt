package com.okuzawats.awesome.presenter.bulletedit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BulletEditViewModel @Inject constructor(
  private val navigator: BulletEditNavigator,
) : ViewModel() {
  fun onBackClicked() = viewModelScope.launch { navigator.popEdit() }

  fun onSaveClicked() {}
}
