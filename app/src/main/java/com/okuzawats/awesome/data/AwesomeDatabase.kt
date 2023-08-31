package com.okuzawats.awesome.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okuzawats.awesome.data.bullet.BulletDao
import com.okuzawats.awesome.data.bulletdate.BulletDateDao
import com.okuzawats.awesome.data.bulletdate.BulletDateEntity
import com.okuzawats.awesome.data.bullet.BulletEntity

@Database(entities = [BulletDateEntity::class, BulletEntity::class], version = 1)
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
