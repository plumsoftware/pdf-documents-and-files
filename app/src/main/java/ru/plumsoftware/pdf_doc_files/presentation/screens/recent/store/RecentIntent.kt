package ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store

import android.net.Uri

sealed class RecentIntent {
    data object InitRecentFiles : RecentIntent()
    data object OnFileClick : RecentIntent()
    data class AddToRecent(val uri: Uri) : RecentIntent()
}