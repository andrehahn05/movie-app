package com.example.movieapp.core.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.black
import com.example.movieapp.ui.theme.yellow


@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottonNavItem.MoviePopular,
        BottonNavItem.MovieSearch,
        BottonNavItem.MovieFavorite,
    )
    NavigationBar(
        modifier = Modifier.background(color = black),
        contentColor = yellow,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { destination ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = {
                          navController.navigate(destination.route){
                              launchSingleTop = true
                          }
                },
                icon = {
                    Icon(imageVector = destination.icon, contentDescription = null)
                },
                label = {
                    Text(text = destination.title)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    MovieAppTheme {
        BottomNavigationBar(navController = rememberNavController())
    }
}