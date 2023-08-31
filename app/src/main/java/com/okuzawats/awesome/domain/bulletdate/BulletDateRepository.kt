package com.okuzawats.awesome.domain.bulletdate

/**
 * Bulletの紐つけられる日付の入出力を管理するRepository
 */
interface BulletDateRepository {
  /**
   * すべての[BulletDate]のリストを取得する。
   */
  suspend fun getAll(): List<BulletDate>

  /**
   * 現在時刻に対応する[BulletDate]を取得する。
   *
   * @return 現在時刻に対応する[BulletDate]
   */
  suspend fun getCurrentDate(): BulletDate

  /**
   * 現在時刻に対応する[BulletDate]を作成・保存する。
   */
  suspend fun createCurrentDate()
}
