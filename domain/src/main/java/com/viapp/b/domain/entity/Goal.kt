package com.viapp.b.domain.entity

open class Goal(
    val name: String,
    val deadline: Date,
    val subtasks: List<Goal> = emptyList(),
)