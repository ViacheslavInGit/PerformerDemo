package com.viapp.b.performer.app.ui.screen.goal.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.viapp.b.presentation.GoalListViewModel


@Suppress("unused")
@Composable
internal fun GoalListScreenCompose.CreateFab(
    goalListViewModel: GoalListViewModel,
) {
    FloatingActionButton(
        onClick = goalListViewModel::onAddClick,
        backgroundColor = MaterialTheme.colors.onPrimary,
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add note",
                tint = MaterialTheme.colors.primary
            )
        },
    )

}