package com.plx11.testapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plx11.testapk.ui.theme.TestapkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestapkTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    Text(text = "Hello from testapk 🚀")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestapkTheme {
        App()
    }
}
