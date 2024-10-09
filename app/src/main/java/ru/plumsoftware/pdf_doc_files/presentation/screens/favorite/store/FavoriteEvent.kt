package ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store

sealed class FavoriteEvent {
    data object InitRecentFiles : FavoriteEvent()
    data object OnFileClick : FavoriteEvent()
}