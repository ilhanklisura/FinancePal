package com.example.financepal.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavHostScreen(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                navController = navController,
                onLoginSuccess = {
                    navController.navigate("profile")
                }
            )
        }
        composable("register") {
            RegisterScreen(onRegisterSuccess = {
                navController.navigate("login")
            })
        }
        composable("profile") {
            ProfileScreen()
        }
        composable("expenses") {
            ExpenseScreen()
        }
        composable("addExpense") {
            AddExpenseScreen(onAddExpenseSuccess = {
                navController.navigate("expenses")
            })
        }
    }
}