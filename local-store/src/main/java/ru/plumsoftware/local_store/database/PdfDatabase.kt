package ru.plumsoftware.local_store.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.plumsoftware.local_store.dao.PdfDocDao
import ru.plumsoftware.local_store.model.PdfModel

@Database(entities = [PdfModel::class], version = 1)
abstract class PdfDatabase : RoomDatabase() {
    abstract fun pdfDao(): PdfDocDao
}