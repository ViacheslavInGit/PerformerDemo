package com.viapp.b.performer.app.ui.screen.goalEdit

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.viapp.b.presentation.GoalEditViewModel
import org.koin.androidx.compose.inject

@Preview
@Composable
fun GoalEditScreenCompose() {

    val goalEditViewModel: GoalEditViewModel by inject()

    goalEditViewModel.init(
        scope = rememberCoroutineScope(),
    )

    GoalEditScreenCompose(
        goalEditViewModel = goalEditViewModel,
    )
}

@Composable
private fun GoalEditScreenCompose(
    goalEditViewModel: GoalEditViewModel,
) {

    Scaffold(
        floatingActionButton = { GoalEditFab(goalEditViewModel) },
        content = {
            GoalEditContent(
                goalEditViewModel = goalEditViewModel,
            )
        },
    )
}
