package com.okuzawats.awesome

import com.okuzawats.awesome.data.AwesomeDatabase
import com.okuzawats.awesome.data.bulletdate.BulletDateDao
import com.okuzawats.awesome.data.bulletdate.BulletDateDaoModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [BulletDateDaoModule::class],
)
class FakeBulletDateDaoModule {
  @Provides
  @Singleton
  fun provideBulletDateDao(awesomeDatabase: AwesomeDatabase): BulletDateDao {
    return awesomeDatabase.bulletDateDao()
  }
}
