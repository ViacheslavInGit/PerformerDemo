package com.viapp.b.performer.data.repository

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.repository.GoalRepository
import com.viapp.b.performer.data.local.GoalQueries
import com.viapp.b.performer.data.mapper.GoalFromDbMapper

class GoalRepositoryImpl(
    private val queries: GoalQueries,
    private val goalFromDb: GoalFromDbMapper,
) : GoalRepository {

    override suspend fun save(goal: Goal) {
        queries.insert(
            goal_id = goal.id,
            name = goal.name,
            description = goal.description,
            deadline = goal.deadline,
            color = goal.color.toLong(),
        )
    }

    override suspend fun getGoalList(): List<Goal> {
        return queries
            .selectAll()
            .executeAsList()
            .map(goalFromDb)
            .apply {
                println("####goals $size")
            }
    }
}