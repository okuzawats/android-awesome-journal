package com.okuzawats.awesome.domain.bullet

import com.okuzawats.awesome.domain.bulletdate.BulletDate

/**
 * Bulletの入出力を管理するRepository
 */
interface BulletRepository {
  /**
   * すべて[Bullet]を取得する。
   */
  @Deprecated("use getBulletsAt instead.")
  suspend fun getBullets(): List<Bullet>

  /**
   * [date]に紐つくすべての[Bullet]を取得する。
   */
  suspend fun getBulletsAt(date: BulletDate): List<Bullet>

  /**
   * 新たな[bullet]を保存する。
   */
  suspend fun create(bullet: Bullet)

  /**
   * [bullet]を更新する。
   */
  suspend fun update(bullet: Bullet)
}
