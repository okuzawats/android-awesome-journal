package com.okuzawats.awesome.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okuzawats.awesome.data.dao.BulletDao
import com.okuzawats.awesome.data.dao.BulletDateDao
import com.okuzawats.awesome.data.entity.BulletDateEntity
import com.okuzawats.awesome.data.entity.BulletEntity

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
