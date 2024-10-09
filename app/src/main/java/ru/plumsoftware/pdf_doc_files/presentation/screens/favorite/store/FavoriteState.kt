package ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store

import ru.plumsoftware.pdf_doc_files.presentation.model.PdfDocumentModel

data class FavoriteState (
    val files: List<PdfDocumentModel> = listOf(),
)