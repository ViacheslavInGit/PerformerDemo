package com.viapp.b.performer.app

import android.app.Application
import com.viapp.b.performer.app.di.data.dataModule
import com.viapp.b.performer.app.di.domain.domainModule
import com.viapp.b.performer.app.di.presentation.presentationModule
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
                dataModule,
                domainModule,
                presentationModule,
            )
        }
    }

    private fun setupTimber() {
        Timber.plant(
            Timber.DebugTree()
        )
    }
}