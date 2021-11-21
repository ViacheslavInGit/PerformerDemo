package com.viapp.b.performer.app.ui.screen.goalEdit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.viapp.b.domain.entity.Goal
import com.viapp.b.performer.app.ui.view.TransparentHintTextField
import com.viapp.b.presentation.GoalEditViewModel

@Composable
fun GoalEditContent(
    goalEditViewModel: GoalEditViewModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
            .padding(16.dp),

        content = {
            Content(
                goalEditViewModel = goalEditViewModel,
            )
        }
    )
}

@Composable
private fun Content(
    goalEditViewModel: GoalEditViewModel,
) {
    val name = goalEditViewModel.goal.collectAsState().value.name ?: ""

    TransparentHintTextField(
        text = name,
        hint = "Title",
        onValueChange = goalEditViewModel::onGoalNameChange,
        onFocusChange = { },
        isHintVisible = goalEditViewModel.isNameHintVisible,
        singleLine = true,
        textStyle = MaterialTheme.typography.h5
    )
}