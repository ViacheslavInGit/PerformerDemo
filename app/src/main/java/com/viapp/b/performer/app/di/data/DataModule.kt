package com.viapp.b.performer.app.di.data

import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.viapp.b.performer.data.local.DateAdapter
import com.viapp.b.performer.data.local.DbTask
import com.viapp.b.performer.data.local.PerformerDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single<SqlDriver> {
        AndroidSqliteDriver(
            PerformerDatabase.Schema,
            androidContext(),
            name = "PerformerDatabase",
        )
    }

    single<DbTask.Adapter> {
        DbTask.Adapter(
            data_Adapter = DateAdapter()
        )
    }

    single<PerformerDatabase> {
        PerformerDatabase(
            driver = get(),
            DbTaskAdapter = get(),
        )
    }

}