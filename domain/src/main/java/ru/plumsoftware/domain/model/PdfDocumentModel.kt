package ru.plumsoftware.domain.model

data class PdfDocumentModel(
    val id: Int,
    val imageUri: String?,
    val imageResId: Int?,
    val title: String?,
    val memoryValue: Float?,
    val isFavorite: Boolean,
    val lastOpenDate: Long,
    val pageCount: Int
)
