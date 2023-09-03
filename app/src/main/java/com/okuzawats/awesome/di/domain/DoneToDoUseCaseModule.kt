package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.domain.done.DefaultDoneToDoUseCase
import com.okuzawats.awesome.domain.done.DoneToDoUseCase
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
