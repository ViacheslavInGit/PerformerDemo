package com.viapp.b.performer.data.mapper

import com.viapp.b.domain.entity.Goal
import com.viapp.b.performer.data.local.DbGoal

class GoalToDbMapper : (Goal) -> DbGoal {

    override fun invoke(goal: Goal) =
        DbGoal(
            goal_id = goal.id,
            name = goal.name,
            deadline = goal.deadline,
        )
}