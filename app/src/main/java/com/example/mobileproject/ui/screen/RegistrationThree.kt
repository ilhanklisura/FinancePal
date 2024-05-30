package com.example.mobileproject.ui.screen

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun ThirdRegScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var passwordRepeat by remember { mutableStateOf("") }
    var checkPassword by remember { mutableStateOf(true) }
    var checkEmail by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_to_financepal__2_),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 30.dp))
        TextField(value = email,
            onValueChange = { email = it },
            enabled = true,
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "e-mail",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "example@example.com")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next))
        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
        TextField(
            value = password,
            onValueChange = { password = it},
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "password",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            visualTransformation = if(showPassword){
                VisualTransformation.None
            }
            else{
                PasswordVisualTransformation()
            },
            isError = false,
            trailingIcon = {
                Icon(
                painter = if(showPassword){
                    painterResource(id = R.drawable.icons8_visibility_24)
                }
                else{
                    painterResource(id = R.drawable.icons8_visibility_24__1_)
                },
                contentDescription = "",
                modifier = Modifier.clickable(onClick = {showPassword = !showPassword })
                    .size(20.dp))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 10.dp))
        TextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it},
            shape = RoundedCornerShape(20),
            modifier = Modifier.width(230.dp),
            label = {
                Text(text = "repeat password",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light)
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = !checkPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done)
        )
        Spacer(modifier = Modifier.size(width = 0.dp, height = 60.dp))

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15),
            modifier = Modifier.size(width = 150.dp, height = 50.dp)
        ) {
            Text(
                text = "Sign Up",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                //modifier = Modifier.padding(horizontal = 20.dp, vertical = 0.dp)
            )
        }
    }
}

fun checkRegEmail(email: String): Boolean{
    return  Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ThirdRegPreview(){
    ThirdRegScreen()

}