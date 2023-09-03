package com.okuzawats.awesome.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ToDoRepositoryModule {
  @Provides
  fun provideDoneToDoRepository(): com.okuzawats.awesome.domain.done.ToDoRepository {
    return object : com.okuzawats.awesome.domain.done.ToDoRepository {
      override suspend fun doneToDo(id: Long): Result<Unit> {
        TODO("Not yet implemented")
      }
    }
  }

  @Provides
  fun provideUnDoneToDoRepository(): com.okuzawats.awesome.domain.undone.ToDoRepository {
    return object : com.okuzawats.awesome.domain.undone.ToDoRepository {
      override suspend fun unDoneToDo(id: Long): Result<Unit> {
        TODO("Not yet implemented")
      }
    }
  }
}
