package com.viapp.b.presentation

import com.viapp.b.domain.entity.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * user created list of groups of tasks
 */
class UserTaskListViewModel {

    val stateFlow: StateFlow<List<Task>> = MutableStateFlow(emptyList())
}