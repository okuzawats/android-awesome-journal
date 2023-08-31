package com.okuzawats.awesome

import com.okuzawats.awesome.data.AwesomeDatabase
import com.okuzawats.awesome.data.bullet.BulletDao
import com.okuzawats.awesome.data.bullet.BulletDaoModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [BulletDaoModule::class],
)
class FakeBulletDaoModule {
  @Provides
  @Singleton
  fun provideBulletDao(awesomeDatabase: AwesomeDatabase): BulletDao {
    return awesomeDatabase.bulletDao()
  }
}
