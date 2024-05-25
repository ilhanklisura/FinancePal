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
fun TransactionsScreen(categories: List<String>) {
    var transactionHistory by remember { mutableStateOf(24860.00f) }
    var income by remember { mutableStateOf(8500.00f) }
    var expense by remember { mutableStateOf(5674.84f) }
    var transactionAmount by remember { mutableStateOf("") }
    var transactionType by remember { mutableStateOf("Select Type") }
    var expanded by remember { mutableStateOf(false) }
    val transactionTypes = listOf("Income", "Expense")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Transactions", style = MaterialTheme.typography.h5, modifier = Modifier.padding(bottom = 16.dp))

        TextField(
            value = transactionAmount,
            onValueChange = { transactionAmount = it },
            label = { Text("Enter Amount") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            TextField(
                value = transactionType,
                onValueChange = { transactionType = it },
                label = { Text("Select Type") },
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
                transactionTypes.forEach { type ->
                    DropdownMenuItem(onClick = {
                        transactionType = type
                        expanded = false
                    }) {
                        Text(text = type)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (transactionAmount.isNotBlank()) {
                    when (transactionType) {
                        "Income" -> {
                            income += transactionAmount.toFloat()
                            transactionHistory += transactionAmount.toFloat()
                        }
                        "Expense" -> {
                            expense += transactionAmount.toFloat()
                            transactionHistory -= transactionAmount.toFloat()
                        }
                    }
                    transactionAmount = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Transaction")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Transaction History: $%.2f".format(transactionHistory), style = MaterialTheme.typography.body1)
        Text("Income: +$%.2f".format(income), style = MaterialTheme.typography.body1)
        Text("Expense: -$%.2f".format(expense), style = MaterialTheme.typography.body1)
    }
}
