package ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store

sealed class RecentLabel {
    data object OnFileClick : RecentLabel()
}