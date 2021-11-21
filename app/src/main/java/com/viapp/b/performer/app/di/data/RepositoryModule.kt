package com.viapp.b.performer.app.di.data

import com.viapp.b.domain.repository.GoalRepository
import com.viapp.b.performer.data.repository.GoalRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<GoalRepository> {
        GoalRepositoryImpl(
            queries = get(),
            goalFromDb = get(),
        )
    }
}