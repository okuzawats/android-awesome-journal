package com.okuzawats.awesome

import com.okuzawats.awesome.data.AwesomeDatabase
import com.okuzawats.awesome.data.AwesomeDatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn


@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [AwesomeDatabaseModule::class],
)
class FakeAwesomeDatabaseModule {
  @Provides
  fun provideFakeAwesomeDatabase(
    fakeAwesomeDatabaseBuilder: FakeAwesomeDatabaseBuilder,
  ): AwesomeDatabase {
    return fakeAwesomeDatabaseBuilder.build()
  }
}
