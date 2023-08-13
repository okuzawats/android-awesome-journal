package com.okuzawats.awesome.domain.bullet

/**
 * BulletのRepository
 */
interface BulletRepository {
  /**
   * BulletのListを返す。
   */
  suspend fun getBullets(): List<Bullet>
}
