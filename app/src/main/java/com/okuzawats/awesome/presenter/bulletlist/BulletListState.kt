package com.okuzawats.awesome.presenter.bulletlist

import com.slack.circuit.runtime.CircuitUiState

/**
 * Bullet一覧画面のUiState
 */
sealed interface BulletListState : CircuitUiState {
    /**
     * Bulletの一覧表示
     */
    data class BulletList(
        val bullets: List<String>,
        val eventSink: (BulletListUiEvent) -> Unit,
    ) : BulletListState {
        val count: Int get() = bullets.size
    }
}
