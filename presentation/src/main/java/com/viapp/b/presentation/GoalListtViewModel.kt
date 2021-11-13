package com.viapp.b.presentation

import com.viapp.b.domain.entity.Goal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GoalListtViewModel {

    val stateFlow: StateFlow<List<Goal>> = MutableStateFlow(emptyList())
}