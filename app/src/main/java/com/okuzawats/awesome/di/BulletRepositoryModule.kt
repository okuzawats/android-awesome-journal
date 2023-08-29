package com.okuzawats.awesome.di

import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.repository.DefaultBulletRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BulletRepositoryModule {
  @Provides
  @Singleton
  fun provideBulletRepository(impl: DefaultBulletRepository): BulletRepository = impl
}
