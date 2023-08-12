package com.okuzawats.awesome.presenter

import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Coroutinesを呼び出し可能な[com.slack.circuit.runtime.presenter.Presenter]
 */
interface AwesomePresenter<T : UiState> : CoroutineScope {
    /**
     * CoroutinesのContext
     *
     * Dispatchers.IOでCoroutinesを実行する。
     */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    /**
     * UiStateを返すComposable関数
     */
    @Composable
    fun present(): UiState

    /**
     * Presenterの破棄時に呼び出すべき処理を実装する。
     */
    fun dispose()
}
