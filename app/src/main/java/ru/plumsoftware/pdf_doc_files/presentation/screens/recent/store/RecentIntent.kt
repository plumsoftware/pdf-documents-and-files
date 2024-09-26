package ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store

sealed class RecentIntent {
    data object InitRecentFiles : RecentIntent()
    data object OnFileClick : RecentIntent()
}