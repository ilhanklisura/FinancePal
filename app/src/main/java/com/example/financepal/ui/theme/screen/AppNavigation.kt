package com.example.financepal.ui.theme.screen

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var categories by remember { mutableStateOf(listOf("Food", "Drinks", "Travel", "Shopping", "Bills")) }

    NavHost(navController = navController, startDestination = HomeDestination.route, modifier = modifier) {
        composable(HomeDestination.route) {
            HomeScreen(
                navigateToLogin = { navController.navigate(LoginDestination.route) },
                navigateToRegister = { navController.navigate(RegistrationDestination.route) }
            )
        }
        composable(LoginDestination.route) {
            LoginScreen(
                navigateToHome = { navController.navigate(MainDestination.route) },
                navigateToRegister = { navController.navigate(RegistrationDestination.route) }
            )
        }
        composable(RegistrationDestination.route) {
            RegistrationScreen(
                onRegistrationComplete = { navController.navigate(MainDestination.route) }
            )
        }
        composable(MainDestination.route) {
            MainScreen(
                navigateToExpenses = { navController.navigate(ExpensesDestination.route) },
                navigateToTransactions = { navController.navigate(TransactionsDestination.route) },
                navigateToCategories = { navController.navigate(CategoriesDestination.route) },
                navigateToSettings = { navController.navigate(SettingsDestination.route) }
            )
        }
        composable(ExpensesDestination.route) {
            ExpensesScreen(categories = categories)
        }
        composable(TransactionsDestination.route) {
            TransactionsScreen(categories = categories)
        }
        composable(CategoriesDestination.route) {
            CategoriesScreen(
                currentCategories = categories,
                onAddCategory = { newCategory ->
                    categories = categories + newCategory
                    navController.navigateUp()
                }
            )
        }
        composable(SettingsDestination.route) {
            SettingsScreen(
                navigateToChangePassword = { navController.navigate(ChangePasswordDestination.route) },
                navigateToPrivacySettings = { navController.navigate(PrivacySettingsDestination.route) },
                navigateToNotificationSettings = { navController.navigate(NotificationSettingsDestination.route) }
            )
        }
        composable(ChangePasswordDestination.route) {
            ChangePasswordScreen { navController.navigateUp() }
        }
        composable(PrivacySettingsDestination.route) {
            PrivacySettingsScreen { navController.navigateUp() }
        }
        composable(NotificationSettingsDestination.route) {
            NotificationSettingsScreen { navController.navigateUp() }
        }
    }
}
