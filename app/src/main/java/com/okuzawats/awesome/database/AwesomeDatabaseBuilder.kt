package com.okuzawats.awesome.database

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AwesomeDatabaseBuilder @Inject constructor(
  @ApplicationContext
  private val context: Context,
) {
  fun build(): AwesomeDatabase {
    return Room
      .databaseBuilder(
        context = context,
        klass = AwesomeDatabase::class.java,
        name = "awesome_database",
      )
      .build()
  }
}
