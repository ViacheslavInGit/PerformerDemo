package com.viapp.b.performer.app

import android.app.Application
import com.viapp.b.performer.app.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(dataModule)
        }
    }

    private fun setupTimber() {
        Timber.plant(
            Timber.DebugTree()
        )
    }
}