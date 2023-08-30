package com.okuzawats.awesome.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Bulletを表すEntity
 */
@Entity(tableName = "bullet")
data class BulletEntity(
  /**
   * BulletのID。primary key。
   */
  @PrimaryKey
  @ColumnInfo(name = "id")
  val id: String,

  /**
   * BulletDateのID。日付にBulletが紐つけられる。
   */
  @ColumnInfo(name = "date_id")
  val dateId: String,

  /**
   * Bulletの種別。
   */
  @ColumnInfo(name = "type")
  val type: String,

  /**
   * Bulletのテキスト。
   */
  @ColumnInfo(name = "text")
  val text: String,
)
