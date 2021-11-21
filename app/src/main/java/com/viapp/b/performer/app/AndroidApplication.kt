package com.viapp.b.performer.app

import android.app.Application
import com.viapp.b.performer.app.di.data.dataModules
import com.viapp.b.performer.app.di.domain.domainModules
import com.viapp.b.performer.app.di.presentation.presentationModules
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
            modules(
                mutableListOf(
                    dataModules,
                    domainModules,
                    presentationModules,
                ).flatten()
            )
        }
    }

    private fun setupTimber() {
        Timber.plant(
            Timber.DebugTree()
        )
    }
}