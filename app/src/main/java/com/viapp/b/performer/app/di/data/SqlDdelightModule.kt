package com.viapp.b.performer.app.di.data

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.viapp.b.performer.app.data.sqldelight.AndroidOpenHelperCallback
import com.viapp.b.performer.data.local.DateAdapter
import com.viapp.b.performer.data.local.DbGoal
import com.viapp.b.performer.data.local.DbTask
import com.viapp.b.performer.data.local.GoalQueries
import com.viapp.b.performer.data.local.PerformerDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sqlDelightModule = module {

    single<SqlDriver> {
        val schema = PerformerDatabase.Schema

        AndroidSqliteDriver(
            schema = schema,
            context = androidContext(),
            name = "PerformerDatabase",
            callback = AndroidOpenHelperCallback(schema),
        )
    }

    single<DbGoal.Adapter> {
        DbGoal.Adapter(
            deadlineAdapter = DateAdapter()
        )
    }

    single<DbTask.Adapter> {
        DbTask.Adapter(
            deadlineAdapter = DateAdapter()
        )
    }

    single<PerformerDatabase> {
        PerformerDatabase(
            driver = get(),
            DbGoalAdapter = get(),
            DbTaskAdapter = get(),
        )
    }

    single<GoalQueries> {
        val database: PerformerDatabase = get()
        database.goalQueries
    }
}