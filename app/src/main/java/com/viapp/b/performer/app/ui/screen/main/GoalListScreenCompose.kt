package com.viapp.b.performer.app.ui.screen.main

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.viapp.b.presentation.GoalListViewModel
import org.koin.androidx.compose.inject


@Preview
@Composable
fun GoalListScreen() {
    val goalListViewModel: GoalListViewModel by inject()

    GoalListScreen(
        goalListViewModel = goalListViewModel,
    )
}

@Composable
private fun GoalListScreen(
    goalListViewModel: GoalListViewModel,
) {

    Scaffold(
        floatingActionButton = { GoalListFab(goalListViewModel) },
        content = {},
    )
}

@Composable
private fun GoalListFab(
    goalListViewModel: GoalListViewModel,
) {
    FloatingActionButton(
        onClick = {
            goalListViewModel.onAddClick()
        },
        content = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
        },
    )
}