package com.okuzawats.awesome

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.okuzawats.awesome.data.AwesomeDatabase
import javax.inject.Inject

class FakeAwesomeDatabaseBuilder @Inject constructor() {
  fun build(): AwesomeDatabase {
    return Room
      .inMemoryDatabaseBuilder(
        context = ApplicationProvider.getApplicationContext<Context>(),
        klass = AwesomeDatabase::class.java,
      )
      .build()
  }
}
