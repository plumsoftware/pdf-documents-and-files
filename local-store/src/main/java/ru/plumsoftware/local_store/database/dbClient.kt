package ru.plumsoftware.local_store.database

import android.content.Context
import androidx.room.Room
import ru.plumsoftware.local_store.dao.Constants

fun db(applicationContext: Context) = Room.databaseBuilder(
    applicationContext,
    PdfDatabase::class.java,
    Constants.pdfDocsDatabase
).build()