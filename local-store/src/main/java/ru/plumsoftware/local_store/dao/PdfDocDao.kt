package ru.plumsoftware.local_store.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.plumsoftware.local_store.model.PdfModel

@Dao
interface PdfDocDao {
    @Query("SELECT * FROM ${Constants.pdfDocsTable}")
    fun getAll(): List<PdfModel>

    @Insert
    fun insertAll(vararg pdfDocs: PdfModel)

    @Query("SELECT * FROM ${Constants.pdfDocsTable} WHERE ${Constants.pdfDocsIsFavorite} == :isFavorite")
    fun loadByFavorite(isFavorite: Boolean): List<PdfModel>
}