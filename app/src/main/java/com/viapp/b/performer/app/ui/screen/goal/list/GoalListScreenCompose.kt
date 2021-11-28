package com.viapp.b.performer.app.ui.screen.goal.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.viapp.b.presentation.GoalListViewModel
import org.koin.androidx.compose.inject

object GoalListScreenCompose {

    @Composable
    fun Draw() {
        val goalListViewModel: GoalListViewModel by inject()

        goalListViewModel.init(
            scope = rememberCoroutineScope(),
        )

        GoalListScreenCompose(
            goalListViewModel = goalListViewModel,
        )
    }

    @Composable
    private fun GoalListScreenCompose(
        goalListViewModel: GoalListViewModel,
    ) {

        Scaffold(
            floatingActionButton = { CreateFab(goalListViewModel) },
            content = { CreateGoalList(goalListViewModel) },
        )
    }
}