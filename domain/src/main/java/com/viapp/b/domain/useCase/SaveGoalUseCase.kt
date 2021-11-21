package com.viapp.b.domain.useCase

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.repository.GoalRepository

interface SaveGoalUseCase {

    suspend operator fun invoke(goal: Goal)
}

class SaveGoalUseCaseImpl(
    private val goalRepository: GoalRepository,
) : SaveGoalUseCase {

    override suspend fun invoke(goal: Goal) {
        goalRepository.save(goal)
    }
}

