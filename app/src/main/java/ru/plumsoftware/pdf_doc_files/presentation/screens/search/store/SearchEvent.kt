package ru.plumsoftware.pdf_doc_files.presentation.screens.search.store

sealed class SearchEvent {
    data object OnSearchClick : SearchEvent()
}