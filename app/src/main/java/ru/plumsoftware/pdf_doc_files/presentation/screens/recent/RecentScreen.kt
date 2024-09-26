package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.plumsoftware.pdf_doc_files.presentation.components.bar.PdfTopBar
import ru.plumsoftware.pdf_doc_files.presentation.components.wrapper.TopAppBarWrapper
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Space
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentLabel

@Composable
fun RecentScreen(recentViewModel: RecentViewModel, navHostController: NavHostController) {
    LaunchedEffect(key1 = Unit) {
        recentViewModel.recentLabel.collect { label ->
            when (label) {
                RecentLabel.InitRecentFiles -> {

                }

                RecentLabel.OnFileClick -> {

                }
            }
        }
    }

    RecentScreenContent()
}

@Composable
private fun RecentScreenContent() {
    TopAppBarWrapper(
        topAppBar = { PdfTopBar(onSearch = {}, onFilter = {}) }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(
                space = Space.extraSmall,
                alignment = Alignment.Top
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

        }
    }
}