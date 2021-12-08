package com.viapp.b.performer.app.ui.screen.goal.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(goals.value.size) { goalIndex ->
                    val goal = goals.value[goalIndex]

                    ViewGoalItem(
                        goal = goal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            },
                        onDeleteClick = {
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}
