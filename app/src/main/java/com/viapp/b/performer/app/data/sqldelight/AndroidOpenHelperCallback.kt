package com.viapp.b.performer.app.data.sqldelight

import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

class AndroidOpenHelperCallback(
    schema: SqlDriver.Schema
) : AndroidSqliteDriver.Callback(
    schema = schema,
) {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
    }

    override fun onUpgrade(
        db: SupportSQLiteDatabase,
        oldVersion: Int,
        newVersion: Int,
    ) {
        super.onUpgrade(db, oldVersion, newVersion)
    }

    override fun onConfigure(db: SupportSQLiteDatabase) {
        super.onConfigure(db)
        db.enableWriteAheadLogging()
    }

    companion object {

        private const val VERSION = 1
    }
}