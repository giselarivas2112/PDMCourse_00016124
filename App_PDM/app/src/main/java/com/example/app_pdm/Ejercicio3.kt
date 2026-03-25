package com.example.app_pdm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecursosTexto(){
    ExerciseThree(
        titulo1 = stringResource(R.string.tituloCuadro1),
        titulo2 = stringResource(R.string.tituloCuadro2),
        titulo3 = stringResource(R.string.tituloCuadro3),
        titulo4 = stringResource(R.string.tituloCuadro4),
        descripcion1 = stringResource(R.string.Descripcion1),
        descripcion2 = stringResource(R.string.Descripcion2),
        descripcion3 = stringResource(R.string.Descripcion3),
        descripcion4 = stringResource(R.string.Descripcion4),

        )
}

@Composable
fun ExerciseThree(
    titulo1: String,
    titulo2: String,
    titulo3: String,
    titulo4: String,
    descripcion1: String,
    descripcion2: String,
    descripcion3: String,
    descripcion4: String,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.systemBarsPadding()) {

        Row(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.weight(1f)){
                Column(modifier = Modifier.fillMaxSize().background(Color(0xFFEADDFF)).padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = titulo1,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(text = descripcion1, textAlign = TextAlign.Justify)
                }
            }
            Box(modifier = Modifier.weight(1f)){
                Column(
                    modifier = Modifier.fillMaxSize().background(Color(0xFFD0BCFF)).padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = titulo2,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = descripcion2, textAlign = TextAlign.Justify)
                }
            }
        }
        Row(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.weight(1f)){
                Column(
                    modifier = Modifier.fillMaxSize().background(Color(0xFFB69DF8)).padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = titulo3,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = descripcion3, textAlign = TextAlign.Justify)
                }
            }
            Box(modifier = Modifier.weight(1f)){
                Column(
                    modifier = Modifier.fillMaxSize().background(Color(0xFFF6EDFF)).padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = titulo4,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = descripcion4, textAlign = TextAlign.Justify)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewEjercicio3(){
    RecursosTexto()
}