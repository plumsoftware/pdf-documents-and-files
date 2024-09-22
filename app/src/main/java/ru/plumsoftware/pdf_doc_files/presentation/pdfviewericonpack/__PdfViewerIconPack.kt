package ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack

import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.collections.List as ____KtList

public object PdfViewerIconPack

private var __PdfIcons: ____KtList<ImageVector>? = null

public val PdfViewerIconPack.PdfIcons: ____KtList<ImageVector>
  get() {
    if (__PdfIcons != null) {
      return __PdfIcons!!
    }
    __PdfIcons = listOf(AddFile, BackIcon, BrightnessIcon, ExpandIcon, Favorite, Filter, More,
        Recent, Search, Settings)
    return __PdfIcons!!
  }
