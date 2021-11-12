package com.example.kmmtemplate.domain.entity

open class Task(
    val name: String,
    val deadline: Date,
    val subtasks: List<Task> = emptyList(),
)