package com.okuzawats.awesome.di.data

import com.okuzawats.awesome.database.AwesomeDatabase
import com.okuzawats.awesome.data.bullet.BulletDao
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
