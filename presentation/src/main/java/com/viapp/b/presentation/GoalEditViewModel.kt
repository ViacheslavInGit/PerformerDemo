package com.viapp.b.presentation

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.navigation.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GoalEditViewModel(
    private val router: Router,
) {

    val goal: StateFlow<Goal> = MutableStateFlow(Goal.Empty)
}