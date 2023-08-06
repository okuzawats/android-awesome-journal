package com.okuzawats.awesome

import android.app.Application
import com.okuzawats.awesome.module.bulletListModule
import org.koin.core.context.startKoin

class AwesomeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                bulletListModule,
            )
        }
    }
}
