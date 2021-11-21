package com.viapp.b.performer.app.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.viapp.b.domain.entity.Goal
import com.viapp.b.presentation.GoalListViewModel


@Composable
fun GoalListContent(
    goalListViewModel: GoalListViewModel,
) {

    val goals = goalListViewModel.goalListFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
            .padding(16.dp),
        content = {
            goals.value.forEach { GoalRow(it) }
        }
    )
}

@Composable
private fun GoalRow(goal: Goal) {
    Row(
        content = {
            Text(
                text = goal.name,
                style = TextStyle(fontSize = 30.sp)
            )
        }
    )
}