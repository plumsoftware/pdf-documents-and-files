package ru.plumsoftware.local_store

import android.content.Context
import ru.plumsoftware.local_store.database.db
import ru.plumsoftware.local_store.model.PdfModel

class LocalStoreStorage(applicationContext: Context) {

    private val pdfDb = db(applicationContext)

    suspend fun getAll() = pdfDb.pdfDao().getAll()

    suspend fun insert(vararg pdfModel: PdfModel) = pdfDb.pdfDao().insertAll(*pdfModel)

    suspend fun loadByFavorite(isFavorite: Boolean) = pdfDb.pdfDao().loadByFavorite(isFavorite = isFavorite)
}