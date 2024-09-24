package ru.plumsoftware.pdf_doc_files.presentation.components.bar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.BackButton
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.BrightnessButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfViewModeTopAppBar(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    onBrightness: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            BackButton(onClick = onBack)
        },
        actions = {
            BrightnessButton(onClick = onBrightness)
        }
    )
}