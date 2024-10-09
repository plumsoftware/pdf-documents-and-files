package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.apache.pdfbox.Loader
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPageContentStream
import ru.plumsoftware.pdf_doc_files.presentation.model.PdfDocumentModel
import ru.plumsoftware.local_store.LocalStoreStorage
import ru.plumsoftware.data.model.PdfInfoDTO
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentIntent
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentLabel
import ru.plumsoftware.pdf_doc_files.presentation.screens.recent.store.RecentState
import java.io.File

class RecentViewModel(
    private val localStoreStorage: LocalStoreStorage
) : ViewModel() {

    val recentState = MutableStateFlow(RecentState())
    val recentLabel = MutableSharedFlow<RecentLabel>()

    private val supervisorCoroutineContext = viewModelScope.coroutineContext + SupervisorJob()

    fun onRecentIntent(intent: RecentIntent) {
        when (intent) {
            RecentIntent.InitRecentFiles -> {
                viewModelScope.launch(context = supervisorCoroutineContext) {
                    recentState.update {
                        it.copy(files = getFiles())
                    }
                }
            }

            RecentIntent.OnFileClick -> {
                viewModelScope.launch {
                    recentLabel.emit(RecentLabel.OnFileClick)
                }
            }

            is RecentIntent.AddToRecent -> {
                viewModelScope.launch(context = supervisorCoroutineContext) {

                    val pdfDocument = getPdfInfo(uri = intent.uri)

                    Log.d("TAG", "pdfDocument: $pdfDocument")
                }
            }

            RecentIntent.OnSearchClick -> {
                viewModelScope.launch {
                    recentLabel.emit(RecentLabel.OnSearchClick)
                }
            }
        }
    }

    private suspend inline fun getFiles(): List<PdfDocumentModel> {
        return localStoreStorage.getAll().map {
            val uri = Uri.parse(it.documentUri)
            val pdfInfoDTO = getPdfInfo(uri)
            PdfDocumentModel(
                id = it.id,
                documentUri = uri,
                pdfDocumentCover = pdfInfoDTO.coverImage,
                name = pdfInfoDTO.fileName,
                memoryValue = pdfInfoDTO.fileSize,
                pageCount = pdfInfoDTO.pageCount,
                isFavorite = it.isFavorite,
                lastOpenDate = it.lastOpenDate
            )
        }
    }

    private fun getPdfInfo(uri: Uri): PdfInfoDTO {
        val file = File(uri.path)
        val pdfDocument: PDDocument = Loader.loadPDF(file)

        val name = pdfDocument.documentInformation.title
        val pages = pdfDocument.numberOfPages
        val size = file.length() / 1024


        return PdfInfoDTO(
            fileName = name,
            pageCount = pages,
            fileSize = size,
            coverImage = null
        )
    }
}