package com.okuzawats.awesome.di.data

import com.okuzawats.awesome.data.database.ToDoDatabase
import com.okuzawats.awesome.data.database.ToDoDatabaseBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ToDoDatabaseModule {
  @Provides
  @Singleton
  fun provideToDoDatabase(builder: ToDoDatabaseBuilder): ToDoDatabase {
    return builder.build()
  }
}
