package com.viapp.b.domain.entity

data class Date(
    val year: Int,
    val month: Int,
    val day: Int,
) {

    companion object {

        val empty = Date(-1, -1, -1)
    }
}