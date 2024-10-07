package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
        val pdfFile = File(uri.path!!)

        if (pdfFile.exists()) {
            val reader = PdfReader(pdfFile)
            val pdfDocument = PdfDocument(reader)

            val pages = pdfDocument.numberOfPages
            val name = pdfFile.name
            val size = pdfFile.length() / 1024.toLong()
            val firstPage = pdfDocument.firstPage.contentBytes

            return PdfInfoDTO(
                fileName = name,
                pageCount = pages,
                fileSize = size,
                coverImage = firstPage
            )
        } else {
            return PdfInfoDTO.empty()
        }
    }
}