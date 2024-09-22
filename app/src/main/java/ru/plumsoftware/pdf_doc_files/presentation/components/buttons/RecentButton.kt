package ru.plumsoftware.pdf_doc_files.presentation.components.buttons

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Alpha
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Size
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.PdfViewerIconPack
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.Recent
import ru.plumsoftware.pdf_doc_files.presentation.theme.PdfTheme

@Composable
fun RecentButton(onClick: () -> Unit, modifier: Modifier = Modifier, isSelected: Boolean = false) {
    val contentColor =
        if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onBackground.copy(
            alpha = Alpha.notSelectedAlpha
        )
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            modifier = modifier,
            onClick = onClick,
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = contentColor,
                containerColor = Color.Transparent
            )
        ) {
            Icon(
                modifier = Modifier.size(size = Size.extraSmallIconButtonSize),
                imageVector = PdfViewerIconPack.Recent,
                contentDescription = stringResource(id = R.string.recent_button_content_desc)
            )
        }
        Text(
            text = stringResource(id = R.string.recent_button),
            style = MaterialTheme.typography.labelMedium.copy(color = contentColor)
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
private fun RecentButtonPreview() {
    PdfTheme {
        Scaffold {
            RecentButton(onClick = {}, isSelected = false)
        }
    }
}