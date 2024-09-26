package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentIntent
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentLabel
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentState

class RecentViewModel : ViewModel() {

    val recentState = MutableStateFlow(RecentState())
    val recentLabel = MutableSharedFlow<RecentLabel>()

    fun onRecentIntent(intent: RecentIntent) {
        when (intent) {
            RecentIntent.InitRecentFiles -> {
                viewModelScope.launch {
                    recentLabel.emit(RecentLabel.InitRecentFiles)
                }
            }
            RecentIntent.OnFileClick -> {
                viewModelScope.launch {
                    recentLabel.emit(RecentLabel.OnFileClick)
                }
            }
        }
    }

    suspend fun getFiles() {

    }
}