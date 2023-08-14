package com.okuzawats.awesome.domain.bullet

/**
 * 1つのBulletを表すデータモデル
 */
data class Bullet(
  val id: String,
  val text: String,
  val done: Boolean,
)
