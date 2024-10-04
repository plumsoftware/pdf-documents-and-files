package ru.plumsoftware.pdf_doc_files.presentation.screens.recent

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.plumsoftware.domain.model.PdfDocumentModel
import ru.plumsoftware.local_store.LocalStoreStorage
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

                    val size = getFileSize(uri = intent.uri)
                    val pair = getPdfInfo(uri = intent.uri)

                    Log.d("TAG", "size: ${size}, page count: ${pair.first}, bitmap: ${pair.second}, uri ${intent.uri}")
                }
            }
        }
    }

    @SuppressLint("Recycle")
    private fun getFileSize(uri: Uri): Long {
        if (recentState.value.contentResolver != null) {
            val contentResolver: ContentResolver = recentState.value.contentResolver!!
            val fileDescriptor = contentResolver.openFileDescriptor(uri, "r")
            val file = File(fileDescriptor?.fileDescriptor?.toString() ?: "")
            return file.length()
        } else
            return 0L
    }

    private fun getPdfInfo(uri: Uri): Pair<Int, Bitmap?> {
        var pageCount = 0
        var cover: Bitmap? = null

        if (recentState.value.contentResolver != null) {
            val parcelFileDescriptor = recentState.value.contentResolver!!.openFileDescriptor(uri, "r")
            if (parcelFileDescriptor != null) {
                val pdfRenderer = PdfRenderer(parcelFileDescriptor)
                pageCount = pdfRenderer.pageCount

                if (pageCount > 0) {
                    val page = pdfRenderer.openPage(0)
                    cover = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
                    page.render(cover, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                    page.close()
                }

                pdfRenderer.close()
                parcelFileDescriptor.close()
            }
            return Pair(pageCount, cover)
        } else
            return Pair(pageCount, cover)
    }

    private suspend inline fun getFiles() =
        localStoreStorage.getAll().map {
            PdfDocumentModel(
                id = it.id,
                imageUri = it.imageUri,
                imageResId = it.imageResId,
                memoryValue = it.memoryValue,
                lastOpenDate = it.lastOpenDate,
                title = it.title,
                isFavorite = it.isFavorite,
                pageCount = it.pageCount
            )
        }
}