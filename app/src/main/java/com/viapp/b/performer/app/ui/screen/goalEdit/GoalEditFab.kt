package com.viapp.b.performer.app.ui.screen.goalEdit

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.viapp.b.presentation.GoalEditViewModel

@Composable
fun GoalEditFab(
    goalEditViewModel: GoalEditViewModel,
) {

    val icon = if (goalEditViewModel.goal.value.isIdCorrect()) {
        Icons.Default.Edit
    } else {
        Icons.Default.Create
    }

    Redraw(
        onClick = goalEditViewModel::onDoneClick,
        imageVector = icon,
    )
}

@Composable
private fun Redraw(
    onClick: () -> Unit,
    imageVector: ImageVector,
) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.primary,
        content = {
            Icon(
                imageVector = imageVector,
                contentDescription = "Save",
            )
        }
    )
}