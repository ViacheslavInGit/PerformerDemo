package com.viapp.b.performer.app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.viapp.b.domain.entity.Date
import com.viapp.b.domain.entity.Goal

@Preview
@Composable
private fun GoalEditScreenCompose() {
    GoalEditScreenCompose(
        goal = Goal(
            name = "Goal name",
            deadline = Date(0, 0, 0),
        )
    )
}

@Composable
fun GoalEditScreenCompose(
    goal: Goal,
) {
    Scaffold(
//        floatingActionButton = { GoalListFab(goalListViewModel) },
        content = {
            GoalEditContent(
                goal = goal,
            )
        },
    )
}

@Composable
private fun GoalEditContent(
    goal: Goal,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Text(text = goal.name)
        },
    )
}


