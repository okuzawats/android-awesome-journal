package com.okuzawats.awesome.data.bullet

import com.okuzawats.awesome.data.AwesomeDatabase
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