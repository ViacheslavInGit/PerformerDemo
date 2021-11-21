package com.viapp.b.presentation

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.navigation.Router
import com.viapp.b.domain.useCase.GetGoalsUseCase
import com.viapp.b.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GoalListViewModel(
    private val router: Router,
    private val getGoals: GetGoalsUseCase,
) : BaseViewModel() {

    private val goalListMutableStateFlow = MutableStateFlow<List<Goal>>(emptyList())
    val goalListFlow: StateFlow<List<Goal>> = goalListMutableStateFlow

    override fun init(scope: CoroutineScope) {
        super.init(scope)
        updateGoalList()
    }

    fun onAddClick() {
        router.openTaskCreationScreen()
    }

    private fun updateGoalList() {
        scope.launch {
            goalListMutableStateFlow.value = getGoals()

            println("### goals = ${goalListFlow.value}")

        }.executeUnique(jobName = "updateGoalList")
    }
}