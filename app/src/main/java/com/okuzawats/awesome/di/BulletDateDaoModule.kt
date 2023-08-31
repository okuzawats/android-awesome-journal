package com.okuzawats.awesome.di

import com.okuzawats.awesome.data.AwesomeDatabase
import com.okuzawats.awesome.data.dao.BulletDateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BulletDateDaoModule {
  @Provides
  @Singleton
  fun provideBulletDateDao(database: AwesomeDatabase): BulletDateDao {
    return database.bulletDateDao()
  }
}
