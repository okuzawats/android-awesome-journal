package com.okuzawats.awesome.di.data

import com.okuzawats.awesome.data.database.ToDoDatabase
import com.okuzawats.awesome.data.todo.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ToDoDaoModule {
  @Provides
  @Singleton
  fun provideBulletDao(database: ToDoDatabase): ToDoDao {
    return database.getToDoDao()
  }
}
