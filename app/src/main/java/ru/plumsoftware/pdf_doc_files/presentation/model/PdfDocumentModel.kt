package ru.plumsoftware.pdf_doc_files.presentation.model

import android.net.Uri

data class PdfDocumentModel(
    val id: Int,
    val documentUri: Uri?,
    val pdfDocumentCover: ByteArray?,
    val name: String?,
    val memoryValue: Long?,
    val pageCount: Int?,
    val isFavorite: Boolean = false,
    val lastOpenDate: Long,
) {
    companion object {
        fun empty() = PdfDocumentModel(
            id = -1,
            documentUri = null,
            pdfDocumentCover = null,
            name = null,
            memoryValue = null,
            pageCount = null,
            isFavorite = false,
            lastOpenDate = 0L,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PdfDocumentModel

        if (id != other.id) return false
        if (documentUri != other.documentUri) return false
        if (pdfDocumentCover != null) {
            if (other.pdfDocumentCover == null) return false
            if (!pdfDocumentCover.contentEquals(other.pdfDocumentCover)) return false
        } else if (other.pdfDocumentCover != null) return false
        if (name != other.name) return false
        if (memoryValue != other.memoryValue) return false
        if (pageCount != other.pageCount) return false
        if (isFavorite != other.isFavorite) return false
        if (lastOpenDate != other.lastOpenDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (documentUri?.hashCode() ?: 0)
        result = 31 * result + (pdfDocumentCover?.contentHashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (memoryValue?.hashCode() ?: 0)
        result = 31 * result + (pageCount ?: 0)
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + lastOpenDate.hashCode()
        return result
    }
}
