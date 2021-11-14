package com.viapp.b.performer.app.di.presentation

import com.viapp.b.presentation.GoalEditViewModel
import com.viapp.b.presentation.GoalListViewModel
import org.koin.dsl.module

val viewModelModule = module {

    factory {
        GoalEditViewModel(
            router = get(),
            saveGoal = get(),
        )
    }

    factory {
        GoalListViewModel(
            router = get(),
            getGoals = get(),
        )
    }
}