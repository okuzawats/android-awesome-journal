package com.okuzawats.awesome.di.data

import com.okuzawats.awesome.database.AwesomeDatabase
import com.okuzawats.awesome.database.AwesomeDatabaseBuilder
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
