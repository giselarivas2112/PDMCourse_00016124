package com.example.app_pdm

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
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
import com.example.app_pdm.AppEjercicioClase.PostApp
import com.example.app_pdm.AppMovies.MovieApp
import com.example.app_pdm.ui.theme.App_PDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        enableEdgeToEdge()
        setContent {
            App_PDMTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Ejercicio 1
                    //RecursosArticulo(modifier = Modifier.padding(innerPadding))

                    //Ejercicio 2
                    //Recursos(modifier = Modifier.padding(innerPadding))

                    //Ejercicio 3
                    //RecursosTexto(modifier = Modifier.padding(innerPadding))

                    //Ejercicio calculadora de propina
                    /*TipCalculator(
                        modifier = Modifier.padding(innerPadding),
                    )*/



                //}
                //App de películas
                //MovieApp()

                //Ejercicio de clase
                PostApp()
            }
        }
    }


override fun onStart() {
    super.onStart()
    Log.d(TAG, "onStart Called")
}

override fun onResume() {
    super.onResume()
    Log.d(TAG, "onResume Called")
}

override fun onRestart() {
    super.onRestart()
    Log.d(TAG, "onRestart Called")
}

override fun onPause() {
    super.onPause()
    Log.d(TAG, "onPause Called")
}

override fun onStop() {
    super.onStop()
    Log.d(TAG, "onStop Called")
}

override fun onDestroy() {
    super.onDestroy()
    Log.d(TAG, "onDestroy Called")
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