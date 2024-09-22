package ru.plumsoftware.pdf_doc_files.presentation.components.buttons

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Size
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.PdfViewerIconPack
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.Search
import ru.plumsoftware.pdf_doc_files.presentation.theme.PdfTheme

@Composable
fun SearchButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Icon(
            modifier = Modifier.size(size = Size.mediumIconButtonSize),
            imageVector = PdfViewerIconPack.Search,
            contentDescription = stringResource(id = R.string.search_button_content_desc)
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    locale = "RU"
)
@Composable
private fun SearchButtonPreview() {
    PdfTheme {
        Scaffold {
            SearchButton({})
        }
    }
}