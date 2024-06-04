package com.example.financepal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.financepal.data.model.Expense
import com.example.financepal.viewmodel.ExpenseViewModel
import kotlinx.coroutines.launch

@Composable
fun ExpenseScreen(expenseViewModel: ExpenseViewModel = viewModel()) {
    val expenses by expenseViewModel.getAllExpenses().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(expenses) { expense ->
            ExpenseItem(expense = expense, onDelete = { expenseViewModel.deleteExpense(it) })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense, onDelete: (Expense) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Amount: ${expense.amount}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Category: ${expense.categoryId}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Description: ${expense.description}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Date: ${expense.date}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onDelete(expense) }) {
                Text("Delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpenseScreenPreview() {
    ExpenseScreen()
}