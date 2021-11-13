package com.viapp.b.performer.data.local

import com.squareup.sqldelight.ColumnAdapter
import com.viapp.b.domain.entity.Date

class DateAdapter : ColumnAdapter<Date, String> {

    override fun decode(databaseValue: String): Date {
        val valuesList = databaseValue.split(' ')

        return Date(
            year = valuesList[0].toInt(),
            month = valuesList[1].toInt(),
            day = valuesList[2].toInt(),
        )
    }

    override fun encode(value: Date): String =
        "${value.year} ${value.month} ${value.day}"

}