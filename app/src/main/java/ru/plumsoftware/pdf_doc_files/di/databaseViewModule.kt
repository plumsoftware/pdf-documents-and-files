package ru.plumsoftware.pdf_doc_files.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.plumsoftware.local_store.LocalStoreStorage

val databaseViewModule = module {
    singleOf(::LocalStoreStorage)
}