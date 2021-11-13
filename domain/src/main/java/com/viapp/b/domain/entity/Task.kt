package com.viapp.b.domain.entity

open class Task(
    val id: Long,
    val name: String,
    val deadline: Date,
    val subtasks: List<Task> = emptyList(),
)