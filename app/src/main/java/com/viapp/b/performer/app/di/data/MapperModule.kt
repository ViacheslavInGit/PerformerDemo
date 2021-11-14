package com.viapp.b.performer.app.di.data

import com.viapp.b.performer.data.mapper.GoalFromDbMapper
import com.viapp.b.performer.data.mapper.GoalToDbMapper
import org.koin.dsl.module

val mapperModule = module {

    single { GoalFromDbMapper() }
    single { GoalToDbMapper() }
}