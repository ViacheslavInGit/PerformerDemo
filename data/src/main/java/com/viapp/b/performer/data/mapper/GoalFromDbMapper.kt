package com.viapp.b.performer.data.mapper

import com.viapp.b.domain.entity.Date
import com.viapp.b.domain.entity.Goal
import com.viapp.b.performer.data.local.DbGoal

class GoalFromDbMapper : (DbGoal) -> Goal {

    override fun invoke(dbGoal: DbGoal) =
        Goal(
            id = dbGoal.goal_id,
            name = dbGoal.name ?: "",
            deadline = dbGoal.deadline ?: Date.empty,
        )
}