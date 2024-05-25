package com.example.financepal.ui.theme.screen

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val title = "Home"
}

object LoginDestination : NavigationDestination {
    override val route = "login"
    override val title = "Login"
}

object RegistrationDestination : NavigationDestination {
    override val route = "register"
    override val title = "Register"
}

object MainDestination : NavigationDestination {
    override val route = "main"
    override val title = "Main Menu"
}

object ExpensesDestination : NavigationDestination {
    override val route = "expenses"
    override val title = "Expenses"
}

object TransactionsDestination : NavigationDestination {
    override val route = "transactions"
    override val title = "Transactions"
}


object CategoriesDestination : NavigationDestination {
    override val route = "categories"
    override val title = "Categories"
}
