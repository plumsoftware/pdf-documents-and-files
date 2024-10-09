package ru.plumsoftware.pdf_doc_files.presentation.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import ru.plumsoftware.lottie_store.LottieRes
import ru.plumsoftware.pdf_doc_files.presentation.components.bar.SearchBar
import ru.plumsoftware.pdf_doc_files.presentation.components.image.NoPdfFiles
import ru.plumsoftware.pdf_doc_files.presentation.components.item.PdfDocItem
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Space
import ru.plumsoftware.pdf_doc_files.presentation.screens.search.store.SearchState

@Composable
fun SearchScreen() {
    val viewModel = koinViewModel<SearchViewModel>()

    LaunchedEffect(key1 = Unit) {
        viewModel.searchEffect.collect { effect ->
            when (effect) {
                else -> {}
            }
        }
    }
    val state = viewModel.searchState.collectAsState()

    SearchScreenContent(state = state)
}

@Composable
private fun SearchScreenContent(state: State<SearchState>) {
    Scaffold(
        topBar = {
            SearchBar(onQueryClick = {})
        }
    ) {
        if (state.value.files.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NoPdfFiles(lottieRes = LottieRes.noFile)
            }
        } else
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(
                    space = Space.extraSmall,
                    alignment = Alignment.Top
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsIndexed(state.value.files) { _, item ->
                    PdfDocItem(
                        pdfDocumentModel = item,
                        onClick = {},
                        onMoreClick = {}
                    )
                }
            }
    }
}