package ru.plumsoftware.local_store.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.plumsoftware.local_store.dao.Constants

@Entity(tableName = Constants.pdfDocsTable)
data class PdfModel(
    @PrimaryKey val id: Int,
    val imageUri: String?,
    val imageResId: Int?,
    val title: String?,
    val memoryValue: Float?,
    val isFavorite: Boolean = false,
    val lastOpenDate: Long,
    val pageCount: Int
)
