package com.viapp.b.performer.app

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.viapp.b.performer.ui.entity.NavigationItem

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
        backgroundColor = Color.DarkGray,
        elevation = 5.dp,
    ) {

        val backStackEntry = navController.currentBackStackEntryAsState()

        navigationItems.forEach { item ->

            val selected = item.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = selected,
                onClick = { onNavigationItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Text(text = item.badgeCount.toString())
                                },
                                content = {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.name,
                                    )
                                }
                            )
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                            )
                        }
                    }

//                    if(selected){
//                        Text(
//                            text =  item.name,
//                            textAlign = TextAlign.Center,
//                            fontSize = 10.sp,
//                        )
//                    }
                },
            )
        }
    }
}
