package com.okuzawats.awesome

import android.app.Application
import org.koin.core.context.startKoin

class AwesomeApp : Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin { modules(awesomeModule) }
  }
}
