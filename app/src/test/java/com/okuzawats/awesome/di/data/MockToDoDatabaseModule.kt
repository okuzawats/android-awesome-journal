package com.okuzawats.awesome.di.data

import com.okuzawats.awesome.data.database.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [ToDoDatabaseModule::class],
)
class MockToDoDatabaseModule {
  @Provides
  fun provideMockToDoDatabase(
    inMemoryToDoDatabaseBuilder: MockToDoDatabaseBuilder,
  ): ToDoDatabase {
    return inMemoryToDoDatabaseBuilder.build()
  }
}
