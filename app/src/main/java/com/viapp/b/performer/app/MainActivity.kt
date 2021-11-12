package com.viapp.b.performer.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.viapp.b.performer.base.BaseActivity
import com.viapp.b.performer.navigation.Routes
import com.viapp.b.performer.ui.entity.NavigationItem

@ExperimentalMaterialApi
class MainActivity : BaseActivity() {

    @Preview(showBackground = true)
    @Composable
    override fun ShowContent() {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    navigationItems = listOf(
                        NavigationItem(
                            name = "goalList",
                            route = Routes.GoalList,
                            icon = Icons.Default.Home
                        ),
                        NavigationItem(
                            name = "settings",
                            route = Routes.Settings,
                            icon = Icons.Default.Settings
                        ),
                    ),
                    navController = navController,
                    onNavigationItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) {
            MainBottomNavigation(navController = navController)
        }
    }
}

@Composable
fun MainBottomNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.GoalList,
        builder = {
            composable(route = Routes.GoalList) {
                GoalListScreen()
            }
            composable(route = Routes.Settings) {
                SettingsScreen()
            }

        }
    )
}

@Composable
fun GoalListScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Text(text = "Goal List")
        },
    )
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Text(text = "Settings")
        },
    )
}
