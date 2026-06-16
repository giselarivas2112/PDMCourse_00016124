package com.example.app_pdm.AppRankeUca.screens.Question

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionBottomSheet(
    onSave: (title: String) -> Unit,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    var title by rememberSaveable { mutableStateOf("") }

    val isValid = title.isNotBlank()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Nueva pregunta",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título de la pregunta") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onDismiss) { Text("Cancelar") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        if (isValid) {
                            onSave(title.trim())
                            onDismiss()
                        }
                    },
                    enabled = isValid
                ) {
                    Text("Guardar")
                }
            }
        }
    }
}