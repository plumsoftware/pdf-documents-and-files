package ru.plumsoftware.pdf_doc_files.presentation.screens.search.store

import ru.plumsoftware.pdf_doc_files.presentation.model.PdfDocumentModel

data class SearchState(
    val query: String = "",
    val files: List<PdfDocumentModel> = listOf(),
)
