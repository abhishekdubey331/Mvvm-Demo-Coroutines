package com.demo.demomeow.application

import android.app.Application
import com.demo.demomeow.module.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger



class DemoMeowApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoMeowApplication)
            modules(appModules)
        }
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}