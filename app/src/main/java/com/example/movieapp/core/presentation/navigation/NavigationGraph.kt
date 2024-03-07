package com.example.movieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottonNavItem.MoviePopular.route,

    ){
        composable(BottonNavItem.MoviePopular.route){

        }
        composable(BottonNavItem.MovieSearch.route){

        }
        composable(BottonNavItem.MovieFavorite.route){

        }
    }

}