package com.viapp.b.performer.app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.viapp.b.domain.entity.Goal
import com.viapp.b.presentation.GoalEditViewModel
import org.koin.androidx.compose.inject

@Preview
@Composable
fun GoalEditScreenCompose() {

    val goalEditViewModel: GoalEditViewModel by inject()

    GoalEditScreenCompose(
        goalEditViewModel = goalEditViewModel,
    )
}

@Composable
private fun GoalEditScreenCompose(
    goalEditViewModel: GoalEditViewModel
) {


    Scaffold(
//        floatingActionButton = { GoalListFab(goalListViewModel) },
        content = {
            GoalEditContent(
                goal = goalEditViewModel.goal.value,
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


