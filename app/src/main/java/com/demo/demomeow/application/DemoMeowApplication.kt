package com.demo.demomeow.application

import android.app.Application
import com.demo.demomeow.module.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DemoMeowApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoMeowApplication)
            modules(appModules)
        }
    }
}