package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.domain.undone.DefaultUnDoneToDoUseCase
import com.okuzawats.awesome.domain.undone.UnDoneToDoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UnDoneToDoUseCaseModule {
  @Binds
  abstract fun bindUnDoneToDoUseCase(impl: DefaultUnDoneToDoUseCase): UnDoneToDoUseCase
}
