package com.demo.demomeow.application

import android.app.Application
import android.content.Context
import com.demo.demomeow.module.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

class DemoMeowApplication : Application() {

    companion object {
        lateinit var mInstance: DemoMeowApplication
        fun getContext(): Context? {
            return mInstance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        startKoin {
            androidContext(this@DemoMeowApplication)
            modules(appModules)
        }
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}