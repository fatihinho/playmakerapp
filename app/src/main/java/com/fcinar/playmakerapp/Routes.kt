package com.fcinar.playmakerapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fcinar.playmakerapp.screen.HomeScreen
import com.fcinar.playmakerapp.screen.LoginScreen
import com.fcinar.playmakerapp.screen.player.CreatePlayerScreen
import com.fcinar.playmakerapp.screen.player.PlayerScreen
import com.fcinar.playmakerapp.screen.squad.CreateSquadScreen
import com.fcinar.playmakerapp.screen.squad.SquadScreen

enum class Destinations(val route: String) {
    LOGIN("login"),
    APP("app"),
    HOME("home"),
    PLAYER("player"),
    CREATE_PLAYER("create_player"),
    SQUAD("squad"),
    CREATE_SQUAD("create_squad")
}

@Composable
@ExperimentalMaterial3Api
fun AuthNavHost(
    navController: NavHostController,
    startDestination: String = Destinations.LOGIN.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.LOGIN.route) {
            LoginScreen(navController)
        }
        composable(Destinations.APP.route) {
            AppNavHost(navController)
        }
    }
}

@Composable
@ExperimentalMaterial3Api
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Destinations.HOME.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.HOME.route) {
            HomeScreen(navController)
        }
        composable(Destinations.PLAYER.route) {
            PlayerScreen(navController)
        }
        composable(Destinations.CREATE_PLAYER.route) {
            CreatePlayerScreen(navController)
        }
        composable(Destinations.SQUAD.route) {
            SquadScreen(navController)
        }
        composable(Destinations.CREATE_SQUAD.route) {
            CreateSquadScreen(navController)
        }
    }
}