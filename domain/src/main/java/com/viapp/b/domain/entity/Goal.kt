package com.viapp.b.domain.entity

open class Goal(
    val name: String,
    val deadline: Date,
    val subtasks: List<Goal> = emptyList(),
) {

    companion object Empty : Goal(
        name = "Empty",
        deadline = Date(0, 0, 0),
    )
}