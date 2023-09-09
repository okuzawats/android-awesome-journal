package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.data.todo.DefaultToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ToDoRepositoryModule {
  @Provides
  fun provideDoneToDoRepository(
    defaultToDoRepository: DefaultToDoRepository,
  ): com.okuzawats.awesome.domain.done.ToDoRepository {
    return defaultToDoRepository
  }

  @Provides
  fun provideUnDoneToDoRepository(
    defaultToDoRepository: DefaultToDoRepository,
  ): com.okuzawats.awesome.domain.undone.ToDoRepository {
    return defaultToDoRepository
  }
}
