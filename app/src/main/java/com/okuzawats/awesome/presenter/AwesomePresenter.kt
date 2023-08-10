package com.okuzawats.awesome.presenter

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.presenter.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Coroutinesを呼び出し可能な[com.slack.circuit.runtime.presenter.Presenter]
 */
interface AwesomePresenter<T : CircuitUiState> : Presenter<T>, CoroutineScope {
    /**
     * CoroutinesのContext
     *
     * Dispatchers.IOでCoroutinesを実行する。
     */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    /**
     * Presenterの破棄時に呼び出すべき処理を実装する。
     */
    fun dispose()
}
