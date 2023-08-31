package com.okuzawats.awesome.data.bullet

import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.repository.DefaultBulletRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BulletRepositoryModule {
  @Binds
  @Singleton
  abstract fun bindBulletRepository(impl: DefaultBulletRepository): BulletRepository
}
