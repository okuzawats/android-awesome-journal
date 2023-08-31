package com.okuzawats.awesome.di

import com.okuzawats.awesome.data.AwesomeDatabase
import com.okuzawats.awesome.data.dao.BulletDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BulletDaoModule {
  @Provides
  @Singleton
  fun provideBulletDao(database: AwesomeDatabase): BulletDao {
    return database.bulletDao()
  }
}
