package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.domain.done.DefaultDoneToDoUseCaseTest.Companion.ID_DONE_TODO_FAILURE
import com.okuzawats.awesome.domain.done.DefaultDoneToDoUseCaseTest.Companion.ID_DONE_TODO_SUCCESS
import com.okuzawats.awesome.domain.undone.DefaultUnDoneToDoUseCaseTest.Companion.ID_UN_DONE_TO_DO_FAILURE
import com.okuzawats.awesome.domain.undone.DefaultUnDoneToDoUseCaseTest.Companion.ID_UN_DONE_TO_DO_SUCCESS
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.coEvery
import io.mockk.mockk

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [ToDoRepositoryModule::class],
)
class MockToDoRepositoryModule {
  @Provides
  fun provideMockDoneToDoRepository(): com.okuzawats.awesome.domain.done.ToDoRepository {
    return mockk<com.okuzawats.awesome.domain.done.ToDoRepository>().also { repository ->
      coEvery {
        repository.doneToDo(ID_DONE_TODO_SUCCESS)
      } returns Result.success(Unit)

      coEvery {
        repository.doneToDo(ID_DONE_TODO_FAILURE)
      } returns Result.failure(Throwable("failed to save"))
    }
  }

  @Provides
  fun provideMockUnDoneToDoRepository(): com.okuzawats.awesome.domain.undone.ToDoRepository {
    return mockk<com.okuzawats.awesome.domain.undone.ToDoRepository>().also { repository ->
      coEvery {
        repository.unDoneToDo(ID_UN_DONE_TO_DO_SUCCESS)
      } returns Result.success(Unit)

      coEvery {
        repository.unDoneToDo(ID_UN_DONE_TO_DO_FAILURE)
      } returns Result.failure(Throwable("failed to save"))
    }
  }
}
