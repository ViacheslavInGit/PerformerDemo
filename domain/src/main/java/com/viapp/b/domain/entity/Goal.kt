package com.example.kmmtemplate.domain.entity

open class Goal(
    val name: String,
    val deadline: Date,
    val subtasks: List<Goal> = emptyList(),
)