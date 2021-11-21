package com.viapp.b.performer.app.di.domain

import com.viapp.b.domain.useCase.GetGoalsUseCase
import com.viapp.b.domain.useCase.GetGoalsUseCaseImpl
import com.viapp.b.domain.useCase.SaveGoalUseCase
import com.viapp.b.domain.useCase.SaveGoalUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    factory<GetGoalsUseCase> {
        GetGoalsUseCaseImpl(
            goalRepository = get(),
        )
    }

    factory<SaveGoalUseCase> {
        SaveGoalUseCaseImpl(
            goalRepository = get(),
        )
    }
}