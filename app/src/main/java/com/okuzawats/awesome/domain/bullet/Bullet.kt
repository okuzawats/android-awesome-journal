package com.okuzawats.awesome.domain.bullet

import java.util.UUID

/**
 * 1つのBulletを表すデータモデル
 */
data class Bullet(
    val id: UUID,
    val text: String,
    val done: Boolean,
)
