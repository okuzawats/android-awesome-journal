package com.okuzawats.awesome

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.okuzawats.awesome.data.AwesomeDatabase
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.test.StandardTestDispatcher
import javax.inject.Inject

class FakeAwesomeDatabaseBuilder @Inject constructor() {
  fun build(): AwesomeDatabase {
    return Room
      .inMemoryDatabaseBuilder(
        context = ApplicationProvider.getApplicationContext(),
        klass = AwesomeDatabase::class.java,
      )
      .setTransactionExecutor(StandardTestDispatcher().asExecutor())
      .setQueryExecutor(StandardTestDispatcher().asExecutor())
      .build()
  }
}