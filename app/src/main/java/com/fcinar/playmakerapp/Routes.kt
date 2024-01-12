package com.fcinar.playmakerapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fcinar.playmakerapp.screen.AboutScreen
import com.fcinar.playmakerapp.screen.CreatePlayerScreen
import com.fcinar.playmakerapp.screen.CreateSquadScreen
import com.fcinar.playmakerapp.screen.HomeScreen
import com.fcinar.playmakerapp.screen.LoginScreen
import com.fcinar.playmakerapp.screen.MainLayout

enum class Destinations(val route: String) {
    LOGIN("login"),
    APP("app"),
    HOME("home"),
    ABOUT("about"),
    CREATE_PLAYER("create_player"),
    CREATE_SQUAD("create_squad")
}

@Composable
fun AuthNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Destinations.LOGIN.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.LOGIN.route) {
            LoginScreen(navController)
        }
        composable(Destinations.APP.route) {
            MainLayout()
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Destinations.HOME.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.HOME.route) {
            HomeScreen(navController)
        }
        composable(Destinations.ABOUT.route) {
            AboutScreen()
        }
        composable(Destinations.CREATE_PLAYER.route) {
            CreatePlayerScreen()
        }
        composable(Destinations.CREATE_SQUAD.route) {
            CreateSquadScreen()
        }
    }
}