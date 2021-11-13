package com.viapp.b.performer.app.di.presentation

import com.viapp.b.presentation.GoalListViewModel
import org.koin.dsl.module

val presentationModule = module {

    factory {
        GoalListViewModel(
            router = get(),
        )
    }
}