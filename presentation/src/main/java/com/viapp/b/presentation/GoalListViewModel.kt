package com.viapp.b.presentation

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.navigation.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GoalListViewModel(
    private val router: Router,
) {

    val stateFlow: StateFlow<List<Goal>> = MutableStateFlow(emptyList())

    fun onAddClick() {
        println("######onAddClick")
    }
}