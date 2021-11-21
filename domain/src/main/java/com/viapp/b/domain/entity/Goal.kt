package com.viapp.b.domain.entity

data class Goal(
    val id: Long?,
    val name: String,
    val deadline: Date,
    val subtasks: List<Goal> = emptyList(),
) {

    fun isIdCorrect(): Boolean = id != null

    companion object {

        val empty = Goal(
            id = null,
            name = "",
            deadline = Date(0, 0, 0),
        )
    }

}