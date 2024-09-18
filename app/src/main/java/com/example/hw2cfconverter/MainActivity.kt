package com.example.hw2cfconverter

import android.R.attr.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Slider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CFSlider()
        }
    }
}

@Composable
fun CFSlider() {

    var sliderPositionC by remember { mutableFloatStateOf(0f) }
    var sliderPositionF by remember { mutableFloatStateOf(32f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Celsius")
        Slider(
            value = sliderPositionC,
            onValueChange = {
                sliderPositionC = it
                sliderPositionF = it * 1.8f + 32f
            },
            valueRange = 0f..100f,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Text(text = sliderPositionC.toString(),
            modifier = Modifier.padding(vertical = 8.dp))

        Text(text = "Fahrenheit",
            modifier = Modifier.padding(vertical = 8.dp))

        Slider(
            value = sliderPositionF,
            onValueChange = {
                if (it < 32f) {
                    sliderPositionF = 32f
                    sliderPositionC = 0f
                } else {
                    sliderPositionF = it
                    sliderPositionC = (it - 32f) / 1.8f
                }
            },
            valueRange = 0f..212f,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Text(text = sliderPositionF.toString())
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {

}