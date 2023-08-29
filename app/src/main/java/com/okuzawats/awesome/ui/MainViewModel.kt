package com.okuzawats.awesome.ui

import androidx.lifecycle.ViewModel
import com.okuzawats.awesome.ui.navigator.MainNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  // TODO privateに変更する。
  val navigator: MainNavigator,
) : ViewModel() {
  // TODO
}
