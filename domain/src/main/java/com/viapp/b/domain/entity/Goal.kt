package com.viapp.b.domain.entity

data class Goal(
    val id: Long?,
    val name: String,
    val description: String,
    val deadline: Date,
    val subtasks: List<Goal> = emptyList(),
    val color: Int,
) {

    fun isIdCorrect(): Boolean = id != null

    companion object {

        const val DEFAULT_COLOR = 0xFF_FF_00_00.toInt()

        val empty = Goal(
            id = null,
            name = "",
            description = "",
            deadline = Date(0, 0, 0),
            color = DEFAULT_COLOR,
        )
    }

}