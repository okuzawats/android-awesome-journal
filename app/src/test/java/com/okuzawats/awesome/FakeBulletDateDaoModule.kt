package com.okuzawats.awesome

import com.okuzawats.awesome.data.AwesomeDatabase
import com.okuzawats.awesome.data.bulletdate.BulletDateDao
import com.okuzawats.awesome.data.bulletdate.BulletDateDaoModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [BulletDateDaoModule::class],
)
class FakeBulletDateDaoModule {
  @Provides
  fun provideBulletDateDao(fakeAwesomeDatabase: AwesomeDatabase): BulletDateDao {
    return fakeAwesomeDatabase.bulletDateDao()
  }
}
