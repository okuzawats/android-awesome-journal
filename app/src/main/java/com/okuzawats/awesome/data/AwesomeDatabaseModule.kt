package com.okuzawats.awesome.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AwesomeDatabaseModule {
  @Provides
  @Singleton
  fun provideAwesomeDatabase(builder: AwesomeDatabaseBuilder): AwesomeDatabase {
    return builder.build()
  }
}
