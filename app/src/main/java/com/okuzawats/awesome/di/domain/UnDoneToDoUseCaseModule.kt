package com.okuzawats.awesome.di.domain

import com.okuzawats.awesome.domain.undone.DefaultUnDoneToDoUseCase
import com.okuzawats.awesome.domain.undone.UnDoneToDoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class UnDoneToDoUseCaseModule {
//  @Binds
//  abstract fun bindUnDoneToDoUseCase(impl: DefaultUnDoneToDoUseCase): UnDoneToDoUseCase
//}

@Module
@InstallIn(SingletonComponent::class)
class UnDoneToDoUseCaseModule {
  @Provides
  fun bindUnDoneToDoUseCase(
    impl: DefaultUnDoneToDoUseCase,
  ): UnDoneToDoUseCase {
    return impl
  }
}