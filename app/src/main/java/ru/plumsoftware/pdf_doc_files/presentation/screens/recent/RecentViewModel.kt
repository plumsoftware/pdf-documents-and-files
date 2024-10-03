package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.plumsoftware.domain.model.PdfDocumentModel
import ru.plumsoftware.local_store.LocalStoreStorage
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentIntent
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentLabel
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentState

class RecentViewModel(
    private val localStoreStorage: LocalStoreStorage
) : ViewModel() {

    val recentState = MutableStateFlow(RecentState())
    val recentLabel = MutableSharedFlow<RecentLabel>()

    private val supervisorCoroutineContext = viewModelScope.coroutineContext + SupervisorJob()

    fun onRecentIntent(intent: RecentIntent) {
        when (intent) {
            RecentIntent.InitRecentFiles -> {
                viewModelScope.launch(context = supervisorCoroutineContext) {
                    recentState.update {
                        it.copy(files = getFiles())
                    }
                }
            }

            RecentIntent.OnFileClick -> {
                viewModelScope.launch {
                    recentLabel.emit(RecentLabel.OnFileClick)
                }
            }
        }
    }

    private suspend inline fun getFiles() =
        localStoreStorage.getAll().map {
            PdfDocumentModel(
                id = it.id,
                imageUri = it.imageUri,
                imageResId = it.imageResId,
                memoryValue = it.memoryValue,
                lastOpenDate = it.lastOpenDate,
                title = it.title,
                isFavorite = it.isFavorite,
                pageCount = it.pageCount
            )
        }
}