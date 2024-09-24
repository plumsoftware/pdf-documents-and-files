package ru.plumsoftware.pdf_doc_files.presentation.components.buttons

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.BrightnessIcon
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.PdfViewerIconPack

@Composable
fun BrightnessButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Icon(
            imageVector = PdfViewerIconPack.BrightnessIcon,
            contentDescription = stringResource(id = R.string.brightness_button_content_desc)
        )
    }
}