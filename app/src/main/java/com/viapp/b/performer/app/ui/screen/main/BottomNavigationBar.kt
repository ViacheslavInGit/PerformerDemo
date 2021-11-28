package com.viapp.b.performer.app.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.viapp.b.performer.app.ui.entity.NavigationItem

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    navigationItems: List<NavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onNavigationItemClick: (NavigationItem) -> Unit,
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp,
    ) {

        val backStackEntry = navController.currentBackStackEntryAsState()

        navigationItems.forEach { item ->
            CreateBottomNavigationItem(
                navigationItem = item,
                backStackEntryState = backStackEntry,
                onNavigationItemClick = onNavigationItemClick,
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun RowScope.CreateBottomNavigationItem(
    navigationItem: NavigationItem,
    backStackEntryState: State<NavBackStackEntry?>,
    onNavigationItemClick: (NavigationItem) -> Unit,
) {
    val selected = navigationItem.route == backStackEntryState.value?.destination?.route

    BottomNavigationItem(
        selected = selected,
        onClick = { onNavigationItemClick(navigationItem) },
        selectedContentColor = Color.Green,
        unselectedContentColor = Color.Gray,
        icon = {
            CreateIcon(
                navigationItem = navigationItem,
                selected = selected,
            )
        },
    )
}


@ExperimentalMaterialApi
@Composable
private fun CreateIcon(
    navigationItem: NavigationItem,
    selected: Boolean,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            if (navigationItem.badgeCount > 0) {
                CreateIconBadged(
                    navigationItem = navigationItem,
                    selected = selected,
                )
            } else {
                CreateIconOrdinary(
                    navigationItem = navigationItem,
                    selected = selected,
                )
            }
        },
    )
}

@ExperimentalMaterialApi
@Composable
private fun CreateIconBadged(
    navigationItem: NavigationItem,
    selected: Boolean,
) {
    BadgedBox(
        badge = {
            Text(text = navigationItem.badgeCount.toString())
        },
        content = {
            Icon(
                imageVector = navigationItem.icon,
                contentDescription = navigationItem.name,
            )
        }
    )
}

@ExperimentalMaterialApi
@Composable
private fun CreateIconOrdinary(
    navigationItem: NavigationItem,
    selected: Boolean,
) {

    val tint = if(selected)  {
        MaterialTheme.colors.secondary
    } else {
        MaterialTheme.colors.secondaryVariant
    }

    Icon(
        imageVector = navigationItem.icon,
        contentDescription = navigationItem.name,
        tint =tint ,
    )
}