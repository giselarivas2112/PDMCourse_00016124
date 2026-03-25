package com.example.app_pdm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Recursos(){
    ExerciseTwo(
        imagen = painterResource(R.drawable.ic_task_completed),
        texto1 = stringResource(R.string.textoTarea1),
        texto2 = stringResource(R.string.textoTarea2)
    )
}
@Composable
fun ExerciseTwo(
    imagen: Painter,
    texto1: String,
    texto2: String,
    modifier: Modifier = Modifier){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = imagen,
            contentDescription = null
        )

    Text(
        text = texto1,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )

    Text(
        text = texto2,
        fontSize = 16.sp
    )
    }

}

@Preview
@Composable
fun PreviewEjercicio2(){
    Recursos()
}