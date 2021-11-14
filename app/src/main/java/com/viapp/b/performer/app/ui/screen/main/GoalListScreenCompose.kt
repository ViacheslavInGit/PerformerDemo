package com.viapp.b.performer.app.ui.screen.main

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.viapp.b.presentation.GoalListViewModel
import org.koin.androidx.compose.inject


@Preview
@Composable
fun GoalListScreenCompose() {
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
        floatingActionButton = { GoalListFab(goalListViewModel) },
        content = {},
    )
}

@Composable
private fun GoalListFab(
    goalListViewModel: GoalListViewModel,
) {
    FloatingActionButton(
        onClick = goalListViewModel::onAddClick,
        backgroundColor = MaterialTheme.colors.primary,
        content = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
        },
    )
}