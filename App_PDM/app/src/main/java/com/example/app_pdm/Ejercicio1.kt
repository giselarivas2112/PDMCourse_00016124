package com.example.app_pdm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecursosArticulo(modifier: Modifier = Modifier){
    ExerciseOne(
        titulo = stringResource(R.string.titulo),
        parrafo1 = stringResource(R.string.parrafo1),
        parrafo2 = stringResource(R.string.parrafo2),
        imagen = painterResource(R.drawable.bg_compose_background),
        modifier = modifier
    )
}

@Composable
fun ExerciseOne(
    titulo: String,
    parrafo1: String,
    parrafo2: String,
    imagen: Painter,
    modifier: Modifier = Modifier
){

    Column(modifier = modifier) {

        Image(
            painter = imagen,
            contentDescription = "Imagen de fondo",
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = titulo,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = parrafo1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        Text(
            text = parrafo2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEjercicio1() {
    RecursosArticulo()
}