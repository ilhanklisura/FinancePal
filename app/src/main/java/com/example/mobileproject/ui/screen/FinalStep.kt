package com.example.mobileproject.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileproject.ui.theme.MobileProjectTheme

@Composable
fun FinalStep(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You are now registered into FinancePal!",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.size(width = 0.dp, height = 25.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15),
            modifier = Modifier.size(width = 130.dp, height = 50.dp)
        ) {
            Text(
                text = "Log In",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FinalStepPreview(){
    MobileProjectTheme{
        FinalStep()
    }

}