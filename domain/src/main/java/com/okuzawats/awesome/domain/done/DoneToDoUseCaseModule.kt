package com.okuzawats.awesome.domain.done

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DoneToDoUseCaseModule {
  @Binds
  abstract fun bindDoneToDoUseCase(impl: DefaultDoneToDoUseCase): DoneToDoUseCase
}
