package com.viapp.b.presentation

import com.example.kmmtemplate.domain.entity.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * like [UserTaskListViewModel], but contains hardcode
 * contains groups for
 *   * products
 *   * pharmacy
 *   * building materials
 */
class ShopTaskListViewModel {

    val stateFlow: StateFlow<List<Task>> = MutableStateFlow(emptyList())
}