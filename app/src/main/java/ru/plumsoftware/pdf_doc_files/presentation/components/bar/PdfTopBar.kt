package ru.plumsoftware.pdf_doc_files.presentation.components.bar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.FilterButton
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.SearchButton
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Padding
import ru.plumsoftware.pdf_doc_files.presentation.theme.PdfTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfTopBar(onSearch: () -> Unit, modifier: Modifier = Modifier, onFilter: () -> Unit) {
    TopAppBar(
        modifier = modifier
            .fillMaxWidth(),
        title = {},
        actions = {
            Row(
                modifier = Modifier.padding(horizontal = Padding.largePadding)
            ) {
                SearchButton(onClick = onSearch)
                FilterButton(onClick = onFilter)
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
private fun PdfTopBarPreview() {
    PdfTheme {
        Scaffold(topBar = { PdfTopBar(onFilter = {}, onSearch = {}) }) {

        }
    }
}