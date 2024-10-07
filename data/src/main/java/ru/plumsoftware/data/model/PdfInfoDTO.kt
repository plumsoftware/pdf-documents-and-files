package ru.plumsoftware.data.model

data class PdfInfoDTO(
    val fileName: String,
    val pageCount: Int,
    val fileSize: Long,
    val coverImage: ByteArray?
) {
    companion object {
        fun empty(): PdfInfoDTO {
            return PdfInfoDTO(
                fileName = "",
                pageCount = 0,
                fileSize = -1L,
                coverImage = null
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PdfInfoDTO

        if (fileName != other.fileName) return false
        if (pageCount != other.pageCount) return false
        if (fileSize != other.fileSize) return false
        if (coverImage != null) {
            if (other.coverImage == null) return false
            if (!coverImage.contentEquals(other.coverImage)) return false
        } else if (other.coverImage != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = fileName.hashCode()
        result = 31 * result + pageCount
        result = 31 * result + fileSize.hashCode()
        result = 31 * result + (coverImage?.contentHashCode() ?: 0)
        return result
    }
}
