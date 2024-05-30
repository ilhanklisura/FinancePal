package com.example.mobileproject.ui.screen

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun SecondRegScreen(){
    var country by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_to_financepal__1_),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 30.dp))
        TextField(
            value = country,
            onValueChange = { country = it },
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "country",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "country")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
        TextField(
            value = city,
            onValueChange = { city = it },
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "city/county",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "city/county")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
        TextField(
            value = status,
            onValueChange = { status = it },
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "status",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "status")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SecondRegPreview(){
    SecondRegScreen()

}