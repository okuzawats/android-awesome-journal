package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.domain.done.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ToDoRepositoryModule {
  @Provides
  fun provideToDoRepository(): ToDoRepository {
    return object : ToDoRepository {
      override suspend fun doneToDo(id: Long): Result<Unit> {
        TODO("Not yet implemented")
      }
    }
  }
}
