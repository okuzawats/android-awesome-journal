package com.okuzawats.awesome.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okuzawats.awesome.data.bullet.BulletDao
import com.okuzawats.awesome.data.bulletdate.BulletDateDao
import com.okuzawats.awesome.data.bulletdate.BulletDateEntity
import com.okuzawats.awesome.data.bullet.BulletEntity

// schemaのexportを無効化している（デフォルトは有効）
// see https://developer.android.com/reference/androidx/room/Database#getExportSchema()
@Database(entities = [BulletDateEntity::class, BulletEntity::class], version = 1, exportSchema = false)
abstract class AwesomeDatabase : RoomDatabase() {
  /**
   * [BulletDateEntity]のDaoを返す。
   */
  abstract fun bulletDateDao(): BulletDateDao

  /**
   * [BulletEntity]のDaoを返す。
   */
  abstract fun bulletDao(): BulletDao
}
