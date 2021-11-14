package com.viapp.b.performer.data.repository

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.repository.GoalRepository
import com.viapp.b.performer.data.local.GoalQueries
import com.viapp.b.performer.data.mapper.GoalFromDbMapper
import com.viapp.b.performer.data.mapper.GoalToDbMapper

class GoalRepositoryImpl(
    private val queries: GoalQueries,
    private val goalFromDb: GoalFromDbMapper,
    private val goalToDb: GoalToDbMapper
) : GoalRepository {

    override suspend fun save(goal: Goal) {
        println("#### save goal $goal")

        goalToDb(goal)
            .run(queries::insert)
    }

    override suspend fun getGoalList(): List<Goal> {
        return queries
            .selectAll()
            .executeAsList()
            .map(goalFromDb)
    }
}