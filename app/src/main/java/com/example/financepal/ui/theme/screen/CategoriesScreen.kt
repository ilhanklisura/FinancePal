package com.example.financepal.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesScreen(
    currentCategories: List<String>,
    onAddCategory: (String) -> Unit
) {
    var newCategory by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Add New Category", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))

        TextField(
            value = newCategory,
            onValueChange = { newCategory = it },
            label = { Text("New Category") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Button(onClick = {
            if (newCategory.isNotBlank()) {
                onAddCategory(newCategory)
                newCategory = ""
            }
        }, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
            Text("Add Category")
        }

        Text("Current Categories:", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 16.dp))
        currentCategories.forEach { category ->
            Text(category, style = MaterialTheme.typography.bodySmall)
        }
    }
}
