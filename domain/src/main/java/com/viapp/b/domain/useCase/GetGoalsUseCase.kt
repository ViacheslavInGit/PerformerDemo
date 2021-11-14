package com.viapp.b.domain.useCase

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.repository.GoalRepository

interface GetGoalsUseCase {

    suspend operator fun invoke(): List<Goal>
}

class GetGoalsUseCaseImpl(
    private val goalRepository: GoalRepository,
) : GetGoalsUseCase {

    override suspend fun invoke(): List<Goal> =
        goalRepository.getGoalList()
}