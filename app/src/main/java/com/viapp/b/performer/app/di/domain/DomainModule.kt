package com.viapp.b.performer.app.di.domain

import com.viapp.b.domain.navigation.Router
import com.viapp.b.performer.app.domain.navigation.AndroidRouter
import org.koin.dsl.module

val domainModule = module {

    factory<Router> {
        AndroidRouter()
    }
}