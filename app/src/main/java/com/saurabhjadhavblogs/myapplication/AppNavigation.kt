package com.saurabhjadhavblogs.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.saurabhjadhavblogs.myapplication.composables.Screen1
import com.saurabhjadhavblogs.myapplication.composables.Screen2
import com.saurabhjadhavblogs.myapplication.composables.Screen3
import com.saurabhjadhavblogs.myapplication.composables.Screen4

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
        composable("screen3") { Screen3(navController) }
        composable("screen4/{data}", arguments = listOf(navArgument("data") { type = NavType.StringType })) { backStackEntry ->
            Screen4(navController, backStackEntry.arguments?.getString("data") ?: "")
        }
    }
}
