package com.okuzawats.awesome.data.bulletdate

import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BulletDateRepositoryModule {
  @Binds
  @Singleton
  abstract fun bindBulletListRepository(impl: DefaultBulletDateRepository): BulletDateRepository
}
