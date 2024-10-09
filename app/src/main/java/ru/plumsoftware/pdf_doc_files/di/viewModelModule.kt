package ru.plumsoftware.pdf_doc_files.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.FavoriteViewModel
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.RecentViewModel

val viewModelModule = module {
    viewModelOf(::RecentViewModel)
    viewModelOf(::FavoriteViewModel)
}