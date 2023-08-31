package com.okuzawats.awesome.data.bulletdate

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * [BulletDateEntity]のDatabase Access Object
 */
@Dao
interface BulletDateDao {
  /**
   * 全ての[BulletDateEntity]を返す。
   */
  @Query("SELECT * FROM bullet_date")
  fun getAll(): List<BulletDateEntity>

  /**
   * [bulletDate]を保存する。
   */
  @Insert
  fun save(bulletDate: BulletDateEntity)
}