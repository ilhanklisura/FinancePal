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
fun SettingsScreen(
    navigateToChangePassword: () -> Unit,
    navigateToPrivacySettings: () -> Unit,
    navigateToNotificationSettings: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Settings", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))
        Button(onClick = navigateToChangePassword, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
            Text("Change Password")
        }
        Button(onClick = navigateToPrivacySettings, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
            Text("Privacy Settings")
        }
        Button(onClick = navigateToNotificationSettings, modifier = Modifier.fillMaxWidth()) {
            Text("Notification Settings")
        }
    }
}
