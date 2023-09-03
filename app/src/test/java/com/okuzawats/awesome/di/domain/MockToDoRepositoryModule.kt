package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.domain.done.ID_FAILURE
import com.okuzawats.awesome.domain.done.ID_SUCCESS
import com.okuzawats.awesome.domain.done.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.every
import io.mockk.mockk

@Module
@TestInstallIn(
  components = [SingletonComponent::class],
  replaces = [ToDoRepositoryModule::class],
)
class MockToDoRepositoryModule {
  @Provides
  fun provideMockToDoRepository(): ToDoRepository {
    return mockk<ToDoRepository>().also { repository ->
      every {
        repository.doneToDo(ID_SUCCESS)
      } returns Result.success(Unit)

      every {
        repository.doneToDo(ID_FAILURE)
      } returns Result.failure(Throwable("failed to save"))
    }
  }
}
