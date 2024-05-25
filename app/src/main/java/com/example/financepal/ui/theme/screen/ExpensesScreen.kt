package com.example.financepal.ui.theme.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.financepal.R

@Composable
fun ExpensesScreen(categories: List<String>) {
    var totalSalary by remember { mutableStateOf(8500.00f) }
    var totalExpense by remember { mutableStateOf(5674.84f) }
    var salaryInput by remember { mutableStateOf("") }
    var expenseInput by remember { mutableStateOf("") }
    var expenseCategory by remember { mutableStateOf("Select Category") }
    var expanded by remember { mutableStateOf(false) }
    val categories = listOf("Salary", "Freelance", "Grocery", "Transport", "Entertainment", "Healthcare")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Expenses", style = MaterialTheme.typography.h5, modifier = Modifier.padding(bottom = 16.dp))

        TextField(
            value = salaryInput,
            onValueChange = { salaryInput = it },
            label = { Text("Enter Salary") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = expenseInput,
            onValueChange = { expenseInput = it },
            label = { Text("Enter Expense") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            TextField(
                value = expenseCategory,
                onValueChange = { expenseCategory = it },
                label = { Text("Select Category") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                enabled = false,
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_drop_down_24),
                            contentDescription = "Dropdown"
                        )
                    }
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(onClick = {
                        expenseCategory = category
                        expanded = false
                    }) {
                        Text(text = category)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (salaryInput.isNotBlank()) {
                    totalSalary += salaryInput.toFloat()
                    salaryInput = ""
                }
                if (expenseInput.isNotBlank()) {
                    totalExpense += expenseInput.toFloat()
                    expenseInput = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Expense")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total Salary: $%.2f".format(totalSalary), style = MaterialTheme.typography.body1)
        Text("Total Expense: $%.2f".format(totalExpense), style = MaterialTheme.typography.body1)
    }
}
