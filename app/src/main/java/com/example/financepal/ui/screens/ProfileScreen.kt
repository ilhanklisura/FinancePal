package com.example.financepal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.financepal.data.model.User
import com.example.financepal.viewmodel.UserViewModel

@Composable
fun ProfileScreen(userViewModel: UserViewModel = viewModel()) {
    val user by userViewModel.currentUser.collectAsState()

    LaunchedEffect(Unit) {
        userViewModel.getCurrentUser()
    }

    user?.let {
        var username by remember { mutableStateOf(it.username) }
        var email by remember { mutableStateOf(it.email) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "FinancePal | Profile", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    userViewModel.updateUser(User(it.id, username, email, it.password))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Update Profile")
            }
        }
    } ?: run {
        Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}