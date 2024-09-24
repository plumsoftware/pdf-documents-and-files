package ru.plumsoftware.pdf_doc_files.presentation.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.Routing
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.Favorite
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.PdfViewerIconPack
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.Recent
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.Settings

sealed class BottomBarButton(
    @StringRes val title: Int,
    val imageVector: ImageVector,
    @StringRes val imageButtonContentDesc: Int,
    val route: String
) {
    data object RecentButtonBottomBar : BottomBarButton(
        title = R.string.recent_button,
        imageVector = PdfViewerIconPack.Recent,
        imageButtonContentDesc = R.string.recent_button_content_desc,
        route = Routing.RECENT
    )

    data object FavouritesButtonBottomBar : BottomBarButton(
        title = R.string.favorites_button,
        imageVector = PdfViewerIconPack.Favorite,
        imageButtonContentDesc = R.string.favorites_button_content_desc,
        route = Routing.FAVORITES
    )

    data object SettingsButtonBottomBar : BottomBarButton(
        title = R.string.settings_button,
        imageVector = PdfViewerIconPack.Settings,
        imageButtonContentDesc = R.string.settings_button_content_desc,
        route = Routing.SETTINGS
    )
}