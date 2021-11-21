package com.viapp.b.presentation

import com.viapp.b.domain.entity.Goal
import com.viapp.b.domain.navigation.Router
import com.viapp.b.domain.useCase.SaveGoalUseCase
import com.viapp.b.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GoalEditViewModel(
    private val router: Router,
    private val saveGoal: SaveGoalUseCase,
) : BaseViewModel() {

    private val goalMutable = MutableStateFlow(Goal.empty)
    val goal: StateFlow<Goal> = goalMutable

    val isNameHintVisible: Boolean
        get() = goal.value.let { goal ->
            goal.name.isEmpty() || goal == Goal.empty
        }

    override fun init(scope: CoroutineScope) {
        super.init(scope)
    }

    fun onDoneClick() {
        scope.launch {
            saveGoal(goal.value)
            router.back()
        }
    }

    fun onGoalNameChange(newName: String) {
        goalMutable.value = goal.value.copy(
            name = newName,
        )
    }
}