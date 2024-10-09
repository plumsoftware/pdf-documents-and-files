package ru.plumsoftware.pdf_doc_files.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.plumsoftware.local_store.LocalStoreStorage
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteEffect
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteEvent
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteState

class FavoriteViewModel(
    private val localStoreStorage: LocalStoreStorage
) : ViewModel() {

    val favoriteState = MutableStateFlow(FavoriteState())
    val favoriteEffect = MutableSharedFlow<FavoriteEffect>()

    private val supervisorCoroutineContext = viewModelScope.coroutineContext + SupervisorJob()

    fun onFavoriteEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.InitRecentFiles -> {}
            FavoriteEvent.OnFileClick -> {
                viewModelScope.launch {
                    favoriteEffect.emit(FavoriteEffect.OnFileClick)
                }
            }

            FavoriteEvent.OnSearchClick -> {
                viewModelScope.launch {
                    favoriteEffect.emit(FavoriteEffect.OnSearchClick)
                }
            }
        }
    }
}