package com.viapp.b.domain.entity

data class Goal(
    val id: Long,
    val name: String,
    val deadline: Date,
    val subtasks: List<Goal> = emptyList(),
) {

    fun isIdCorrect(): Boolean = id != NO_ID


    companion object {
        private const val NO_ID = -1L

        val empty = Goal(
            id = NO_ID,
            name = "",
            deadline = Date(0, 0, 0),
        )
    }

}