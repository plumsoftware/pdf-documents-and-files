package ru.plumsoftware.pdf_doc_files.presentation.components.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Size
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.More
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.PdfViewerIconPack

@Composable
fun MoreButton(modifier: Modifier = Modifier, onClick: (Boolean) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = {
            isExpanded = !isExpanded
            onClick(isExpanded)
        },
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Icon(
            modifier = Modifier
                .size(size = Size.mediumIconButtonSize),
            imageVector = PdfViewerIconPack.More,
            contentDescription = stringResource(id = R.string.more_button_content_description)
        )
    }
}