package ru.plumsoftware.pdf_doc_files.presentation.screens.favorite

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.plumsoftware.data.model.PdfInfoDTO
import ru.plumsoftware.local_store.LocalStoreStorage
import ru.plumsoftware.pdf_doc_files.presentation.model.PdfDocumentModel
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteEffect
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteEvent
import ru.plumsoftware.pdf_doc_files.presentation.screens.favorite.store.FavoriteState
import java.io.File

class FavoriteViewModel(
    private val localStoreStorage: LocalStoreStorage
) : ViewModel() {

    val favoriteState = MutableStateFlow(FavoriteState())
    val favoriteEffect = MutableSharedFlow<FavoriteEffect>()

    private val supervisorCoroutineContext = viewModelScope.coroutineContext + SupervisorJob()

    fun onFavoriteEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.InitRecentFiles -> {
                viewModelScope.launch(context = supervisorCoroutineContext) {
                    favoriteState.update {
                        it.copy(files = getFiles())
                    }
                }
            }
            FavoriteEvent.OnFileClick -> {
                viewModelScope.launch {
                    favoriteEffect.emit(FavoriteEffect.OnFileClick)
                }
            }

            FavoriteEvent.OnSearchClick -> {
                viewModelScope.launch {
                    favoriteEffect.emit(FavoriteEffect.OnSearchClick)
                }
            }
        }
    }

    private suspend inline fun getFiles(): List<PdfDocumentModel> {
        return localStoreStorage.loadByFavorite(isFavorite = true).map {
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