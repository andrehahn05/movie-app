package com.example.movieapp.core.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.movieapp.core.presentation.navigation.BottomNavigationBar
import com.example.movieapp.core.presentation.navigation.NavigationGraph

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        content = { innerPadding ->
            NavigationGraph(navController = navController)
        }
    )
}


