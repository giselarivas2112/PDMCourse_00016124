package com.example.app_pdm.AppRankeUca.screens.Question

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionsScreen(
    onQuestionClick: (Int) -> Unit,
    navigateToHome: () -> Unit,
    viewModel: QuestionsViewModel = viewModel(factory = QuestionsViewModel.Factory)
) {
    val questions by viewModel.questions.collectAsStateWithLifecycle()
    var showSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        topBar = {
            TopAppBar(
                title = { Text("Preguntas") },
                actions = {
                    TextButton(onClick = { showSheet = true }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Nueva pregunta")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Nueva")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            if (questions.isEmpty()) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Inbox,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.height(36.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Todavía no hay preguntas",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Toca Nueva para crear la primera.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items = questions, key = { it.id }) { question ->
                        ElevatedCard(
                            modifier = Modifier.clickable { onQuestionClick(question.id) }
                        ) {
                            ListItem(
                                headlineContent = {
                                    Text(
                                        text = question.title,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                },
                                supportingContent = {
                                    Text(
                                        text = "${question.optionCount} opciones",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                },
                                trailingContent = {
                                    IconButton(onClick = { viewModel.deleteQuestion(question) }) {
                                        Icon(
                                            imageVector = Icons.Default.DeleteOutline,
                                            contentDescription = "Borrar ${question.title}",
                                            tint = MaterialTheme.colorScheme.error
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            }
            Button(
                onClick = navigateToHome,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Regresar")
            }
        }
    }

    if (showSheet) {
        QuestionBottomSheet(
            onSave = { title -> viewModel.addQuestion(title) },
            onDismiss = { showSheet = false }
        )
    }
}