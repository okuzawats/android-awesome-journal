package com.okuzawats.awesome.di.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.okuzawats.awesome.data.database.ToDoDatabase
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.test.StandardTestDispatcher
import javax.inject.Inject

class MockToDoDatabaseBuilder @Inject constructor() {
  fun build(): ToDoDatabase {
    return Room
      .inMemoryDatabaseBuilder(
        context = ApplicationProvider.getApplicationContext(),
        klass = ToDoDatabase::class.java,
      )
      .setTransactionExecutor(StandardTestDispatcher().asExecutor())
      .setQueryExecutor(StandardTestDispatcher().asExecutor())
      .build()
  }
}
