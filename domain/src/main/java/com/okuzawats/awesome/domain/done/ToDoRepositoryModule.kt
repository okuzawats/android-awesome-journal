package com.okuzawats.awesome.domain.done

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ToDoRepositoryModule {
  @Provides
  fun provideToDoRepository(): ToDoRepository {
    return object : ToDoRepository {}
  }
}
