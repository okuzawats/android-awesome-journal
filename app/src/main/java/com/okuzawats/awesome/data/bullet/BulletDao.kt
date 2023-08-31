package com.okuzawats.awesome.data.bullet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * [BulletEntity]のDatabase Access Object
 */
@Dao
interface BulletDao {
  /**
   * [dateId]に紐つけられたすべての[BulletEntity]を返す。
   */
  @Query("SELECT * FROM bullet WHERE date_id = :dateId")
  fun getAllBulletAt(dateId: String): List<BulletEntity>

  /**
   * 新たな[bullet]を保存する。
   */
  @Insert
  fun save(bullet: BulletEntity)

  /**
   * 既に存在する[bullet]を更新する。
   */
  @Update
  fun update(bullet: BulletEntity)
}
