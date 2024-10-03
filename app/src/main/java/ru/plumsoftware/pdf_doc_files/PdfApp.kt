package ru.plumsoftware.pdf_doc_files

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.plumsoftware.pdf_doc_files.di.databaseViewModule
import ru.plumsoftware.pdf_doc_files.di.viewModelModule

class PdfApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PdfApp)
            modules(viewModelModule, databaseViewModule)
        }
    }
}