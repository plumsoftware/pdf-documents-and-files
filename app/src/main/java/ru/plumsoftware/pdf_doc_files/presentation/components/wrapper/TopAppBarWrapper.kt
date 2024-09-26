package ru.plumsoftware.pdf_doc_files.presentation.components.wrapper

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TopAppBarWrapper(
    topAppBar: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topAppBar
    ) { paddingValues ->
        content(paddingValues)
    }
}