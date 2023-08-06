package com.okuzawats.awesome

import com.slack.circuit.runtime.CircuitUiEvent

/**
 * Bullet一覧画面のUiEvent
 */
sealed interface BulletListUiEvent : CircuitUiEvent {
    /**
     * Bulletのクリックイベント
     */
    data object OnBulletClick : BulletListUiEvent
}
