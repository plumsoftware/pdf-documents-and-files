package ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store

import ru.plumsoftware.domain.model.PdfDocumentModel

data class RecentState(
    val files: List<PdfDocumentModel> = listOf()
)
