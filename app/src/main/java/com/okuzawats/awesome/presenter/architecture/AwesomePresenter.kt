package com.okuzawats.awesome.presenter.architecture

import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Coroutinesを呼び出し可能なPresenter
 */
abstract class AwesomePresenter<T : UiState> {

  class PresenterScope : CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.IO
  }

  private val presenterScope: PresenterScope = PresenterScope()

  private var _job: Job? = null

  /**
   * CoroutineScopeをlaunchする。
   */
  fun launch(block: suspend CoroutineScope.() -> Unit) {
    _job = presenterScope.launch { block() }
  }

  /**
   * Presenterの破棄時に呼び出すべき処理を実装する。
   */
  @CallSuper
  open fun dispose() {
    _job?.cancel()
    _job = null
  }

  /**
   * UiStateを返すComposable関数
   */
  @Composable
  abstract fun present(): UiState
}
