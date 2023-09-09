package com.okuzawats.awesome.di.data

import com.okuzawats.awesome.data.AwesomeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [AwesomeDatabaseModule::class],
)
class InMemoryAwesomeDatabaseModule {
  @Provides
  fun provideMockAwesomeDatabase(
    inMemoryAwesomeDatabaseBuilder: InMemoryAwesomeDatabaseBuilder,
  ): AwesomeDatabase {
    return inMemoryAwesomeDatabaseBuilder.build()
  }
}
