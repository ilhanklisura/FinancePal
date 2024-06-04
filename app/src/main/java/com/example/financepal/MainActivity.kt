package com.example.financepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.financepal.ui.theme.FinancePalTheme
import com.example.financepal.ui.screens.NavHostScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinancePalTheme {
                NavHostScreen()
            }
        }
    }
}