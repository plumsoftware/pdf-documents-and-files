package ru.plumsoftware.pdf_doc_files.di

import org.koin.dsl.module
import ru.plumsoftware.local_store.database.db

val databaseViewModule = module {
    single { db(applicationContext = get()) }
}