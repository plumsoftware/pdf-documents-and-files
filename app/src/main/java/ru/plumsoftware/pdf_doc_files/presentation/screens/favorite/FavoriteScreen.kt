package ru.plumsoftware.pdf_doc_files.presentation.screens.favorite

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.plumsoftware.lottie_store.LottieRes
import ru.plumsoftware.pdf_doc_files.presentation.components.bar.PdfBottomBar
import ru.plumsoftware.pdf_doc_files.presentation.components.bar.PdfTopBar
import ru.plumsoftware.pdf_doc_files.presentation.components.image.NoPdfFiles
import ru.plumsoftware.pdf_doc_files.presentation.components.item.PdfDocItem
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Space
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteEffect
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteEvent
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteState

@Composable
fun FavoriteScreen(navHostController: NavHostController) {
    val viewModel = koinViewModel<FavoriteViewModel>()

    LaunchedEffect(key1 = Unit) {
        viewModel.favoriteEffect.collect { effect ->
            when (effect) {
                FavoriteEffect.OnFileClick -> {}
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.onFavoriteEvent(FavoriteEvent.InitRecentFiles)
    }

    val state = viewModel.favoriteState.collectAsState()
    RecentScreenContent(state = state, navHostController = navHostController, onFavoriteEvent = viewModel::onFavoriteEvent)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun RecentScreenContent(state: State<FavoriteState>, navHostController: NavHostController, onFavoriteEvent: (FavoriteEvent) -> Unit) {
    Scaffold(
        bottomBar = {
            PdfBottomBar(modifier = Modifier.fillMaxWidth(), navHost = navHostController, selectedIndex = 1)
        },
        topBar = {
            PdfTopBar(onSearch = {}, onFilter = {})
        },
    ) { innerPadding ->

        if (state.value.files.isEmpty()) {
            Column(
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
                itemsIndexed(state.value.files) { index, item ->
                    PdfDocItem(
                        pdfDocumentModel = item,
                        onClick = {
                            onFavoriteEvent(FavoriteEvent.OnFileClick)
                        },
                        onMoreClick = {}
                    )
                }
            }
    }
}