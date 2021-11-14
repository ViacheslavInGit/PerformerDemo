package com.viapp.b.domain.repository

import com.viapp.b.domain.entity.Goal

interface GoalRepository {

    /**
     * insert if task with this [Goal.id] doesn`t exist
     * update if exist
     */
    suspend fun save(goal: Goal)

    suspend fun getGoalList(): List<Goal>
}