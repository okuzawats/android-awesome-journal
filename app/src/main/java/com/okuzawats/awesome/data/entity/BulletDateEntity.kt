package com.okuzawats.awesome.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Bulletの日付を表すEntity
 */
@Entity(tableName = "bullet_date")
data class BulletDateEntity (
  /**
   * BulletDateのID。primary key。
   */
  @PrimaryKey
  @ColumnInfo(name = "id")
  val id: String,

  /**
   * 日付の文字列表現。
   */
  @ColumnInfo(name = "date")
  val date: String,
)
