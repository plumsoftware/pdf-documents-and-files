package ru.plumsoftware.pdf_doc_files.presentation.screens.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.plumsoftware.local_store.LocalStoreStorage
import ru.plumsoftware.pdf_doc_files.presentation.screens.search.store.SearchEffect
import ru.plumsoftware.pdf_doc_files.presentation.screens.search.store.SearchEvent
import ru.plumsoftware.pdf_doc_files.presentation.screens.search.store.SearchState

class SearchViewModel(
    private val localStoreStorage: LocalStoreStorage
) : ViewModel() {

    val searchState = MutableStateFlow(SearchState())
    val searchEffect = MutableSharedFlow<SearchEffect>()

    fun onSearchEvent(event: SearchEvent) {
        when (event) {
            SearchEvent.OnSearchClick -> {

            }
        }
    }
}
