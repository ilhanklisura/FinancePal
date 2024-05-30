package com.example.mobileproject.ui.screen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstRegScreen() {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    val state = rememberDatePickerState()
    var dateOfBirth by remember { mutableStateOf("") }
    var openCalendar by remember { mutableStateOf(false) }
    var showDate by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome!",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 30.dp))
        Image(
            painter = painterResource(id = R.drawable.welcome_to_financepal),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 30.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "name",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "name")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
        TextField(
            value = surname,
            onValueChange = { surname = it },
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "surname",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "surname")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
        TextField(
            value = dateOfBirth,
            onValueChange = {dateOfBirth = it},
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = { Text(text = "date of birth",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light)},
            isError = false,
            trailingIcon = {Icon(
                Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .clickable { openCalendar = true }
                    .align(Alignment.Start)
            )
                if(openCalendar){
                    DatePickerDialog(
                        onDismissRequest = { openCalendar = false },
                        confirmButton = {
                            Button(onClick = { showDate = true ;openCalendar = false  }) {
                                Text(text = "Confirm")
                            }
                        },
                    )
                    {
                        DatePicker(
                            state = state
                        )
                    }
                }
            }
        )
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Have an account? Log In here!",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FirstRegPreview(){
    FirstRegScreen()
}