package com.example.financepal.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    navigateToExpenses: () -> Unit,
    navigateToTransactions: () -> Unit,
    navigateToSettings: () -> Unit,
    navigateToCategories: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Main Menu", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))
        Button(onClick = navigateToExpenses, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
            Text("Expenses")
        }
        Button(onClick = navigateToTransactions, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
            Text("Transactions")
        }
        Button(onClick = navigateToSettings, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
            Text("Settings")
        }
        Button(onClick = navigateToCategories, modifier = Modifier.fillMaxWidth()) {
            Text("Categories")
        }
    }
}
