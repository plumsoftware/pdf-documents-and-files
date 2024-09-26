package ru.plumsoftware.domain.model

data class PdfDocumentModel(
    val id: Int,
    val imageUri: String?,
    val imageResId: Int?,
    val title: String?,
    val memoryValue: Float?,
    val isFavorite: Boolean = false,
    val lastOpenDate: Long,
    val pageCount: Int
) {
    companion object {
        fun empty() = PdfDocumentModel(
            id = -1,
            imageUri = null,
            imageResId = null,
            title = null,
            memoryValue = null,
            isFavorite = false,
            lastOpenDate = 0L,
            pageCount = 0
        )
    }
}
