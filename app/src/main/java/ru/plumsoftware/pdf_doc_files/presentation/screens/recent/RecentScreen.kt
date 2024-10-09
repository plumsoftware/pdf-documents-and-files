package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import ru.plumsoftware.lottie_store.LottieRes
import ru.plumsoftware.pdf_doc_files.Routing
import ru.plumsoftware.pdf_doc_files.presentation.components.bar.PdfBottomBar
import ru.plumsoftware.pdf_doc_files.presentation.components.bar.PdfTopBar
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.PrimaryButton
import ru.plumsoftware.pdf_doc_files.presentation.components.image.NoPdfFiles
import ru.plumsoftware.pdf_doc_files.presentation.components.item.PdfDocItem
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Space
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentIntent
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentLabel
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentState

@Composable
fun RecentScreen(navHostController: NavHostController) {

    val recentViewModel = koinViewModel<RecentViewModel>()

    LaunchedEffect(key1 = Unit) {
        recentViewModel.recentLabel.collect { label ->
            when (label) {
                RecentLabel.OnFileClick -> {

                }

                RecentLabel.OnSearchClick -> {
                    navHostController.navigate(route = Routing.SEARCH_R)
                }
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        recentViewModel.onRecentIntent(RecentIntent.InitRecentFiles)
    }

    val contentResolver = LocalContext.current.contentResolver
    val state =
        recentViewModel.recentState.collectAsState(initial = RecentState(contentResolver = contentResolver))
    RecentScreenContent(
        state = state,
        navHostController = navHostController,
        onRecentIntent = recentViewModel::onRecentIntent
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun RecentScreenContent(
    state: State<RecentState>,
    navHostController: NavHostController,
    onRecentIntent: (RecentIntent) -> Unit
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                onRecentIntent(RecentIntent.AddToRecent(uri = result.data?.data!!))
            }
        }
    )

    Scaffold(
        bottomBar = {
            PdfBottomBar(
                modifier = Modifier.fillMaxWidth(),
                navHost = navHostController,
                selectedIndex = 0
            )
        },
        floatingActionButton = {
            PrimaryButton(onClick = {
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "application/pdf"
                    addCategory(Intent.CATEGORY_OPENABLE)
                }
                launcher.launch(intent)
            })
        },
        topBar = {
            PdfTopBar(
                onSearch = {
                    onRecentIntent(RecentIntent.OnSearchClick)
                },
                onFilter = {}
            )
        },
    ) { innerPadding ->
        if (state.value.files.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
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
                            onRecentIntent(RecentIntent.OnFileClick)
                        },
                        onMoreClick = {}
                    )
                }
            }
    }
}