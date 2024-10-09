package ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store

sealed class FavoriteEffect {
    data object OnFileClick : FavoriteEffect()
}