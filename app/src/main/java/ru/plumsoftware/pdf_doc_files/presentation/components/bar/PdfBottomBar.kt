package ru.plumsoftware.pdf_doc_files.presentation.components.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.BottomBarButton
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Padding
import ru.plumsoftware.pdf_doc_files.presentation.model.BottomBarButton

@Composable
fun PdfBottomBar(modifier: Modifier = Modifier) {
    val selectedIndex by remember { mutableIntStateOf(0) }
    val bottomBarButtons = arrayOf<BottomBarButton>(
        BottomBarButton.RecentButtonBottomBar,
        BottomBarButton.FavouritesButtonBottomBar,
        BottomBarButton.SettingsButtonBottomBar,
    )

    Row(
        modifier = Modifier
            .padding(horizontal = Padding.largePadding, vertical = Padding.mediumPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        bottomBarButtons.forEachIndexed { index, bottomBarButton ->
            BottomBarButton(
                onClick = {},
                bottomBarButton = bottomBarButton,
                isSelected = selectedIndex == index
            )
        }
    }
}