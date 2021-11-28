package com.viapp.b.performer.app.ui.screen.goal.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.viapp.b.domain.entity.Goal
import com.viapp.b.performer.app.ui.theme.AppColor
import com.viapp.b.performer.app.ui.theme.AppPadding
import com.viapp.b.performer.app.ui.theme.AppShape
import com.viapp.b.presentation.GoalListViewModel


@Suppress("unused")
@Composable
internal fun GoalListScreenCompose.CreateGoalList(
    goalListViewModel: GoalListViewModel,
) {

    val goals = goalListViewModel.goalListFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        content = {
            goals.value.forEach { GoalRow(it) }
        }
    )
}

@Composable
private fun GoalRow(goal: Goal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppPadding.default),
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(15.dp, CircleShape)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.secondary),
                contentAlignment = Alignment.Center,
                content = {
                    Text(
                        text = goal.name,
                        style = TextStyle(fontSize = AppPadding.Text.large),
                        color = MaterialTheme.colors.primary,
                    )
                }
            )
        }
    )
}

