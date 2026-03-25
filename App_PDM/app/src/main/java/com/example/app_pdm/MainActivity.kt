package com.example.app_pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_pdm.ui.theme.App_PDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_PDMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Ejercicio 1
                    RecursosArticulo(modifier = Modifier.padding(innerPadding))

                    //Ejercicio 2
                    //Recursos(modifier = Modifier.padding(innerPadding))

                    //Ejercicio 3
                    //RecursosTexto(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App_PDMTheme {
        Greeting("Android")
    }
}