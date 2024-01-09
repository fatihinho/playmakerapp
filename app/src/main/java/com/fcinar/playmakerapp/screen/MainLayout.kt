package com.fcinar.playmakerapp.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fcinar.playmakerapp.AppNavHost
import com.fcinar.playmakerapp.Destinations
import com.fcinar.playmakerapp.R
import com.fcinar.playmakerapp.component.TopAppBarComponent
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainLayout() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val navController: NavHostController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val selectedItem = remember { mutableStateOf(Destinations.HOME.route) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(stringResource(id = R.string.app_name), modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id = R.string.home)) },
                    selected = selectedItem.value == Destinations.HOME.route,
                    onClick = {
                        navController.navigate(Destinations.HOME.route)
                        scope.launch {
                            drawerState.close()
                            selectedItem.value = Destinations.HOME.route
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = stringResource(id = R.string.about)) },
                    selected = selectedItem.value == Destinations.ABOUT.route,
                    onClick = {
                        navController.navigate(Destinations.ABOUT.route)
                        scope.launch {
                            drawerState.close()
                            selectedItem.value = Destinations.ABOUT.route
                        }
                    }
                )
            }
        },
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBarComponent(
                    scrollBehavior = scrollBehavior,
                    scope = scope,
                    drawerState = drawerState,
                    title = "",
                    showBackIcon = false,
                    navController = navController
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Snackbar")
                        }
                    },
                ) {
                    Icon(Icons.Filled.Add, "Floating action button.")
                }
            }
        ) {
            AppNavHost(modifier = Modifier.padding(it), navController = navController)
        }
    }
}