package ru.plumsoftware.pdf_doc_files.presentation.components.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.BottomBarButton
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Blur
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Padding
import ru.plumsoftware.pdf_doc_files.presentation.model.BottomBarButton
import ru.plumsoftware.pdf_doc_files.presentation.theme.ExtendedTheme

@Composable
fun PdfBottomBar(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val bottomBarButtons = arrayOf(
        BottomBarButton.RecentButtonBottomBar,
        BottomBarButton.FavouritesButtonBottomBar,
        BottomBarButton.SettingsButtonBottomBar,
    )

    Card(
        modifier = modifier
            .blur(radius = Blur.mediumBlur),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = ExtendedTheme.extendedColorScheme.cardColor.colorContainer,
            contentColor = ExtendedTheme.extendedColorScheme.cardColor.onColorContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = Padding.largePadding, vertical = Padding.mediumPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            bottomBarButtons.forEachIndexed { index, bottomBarButton ->
                BottomBarButton(
                    onClick = {
                        selectedIndex = index
                    },
                    bottomBarButton = bottomBarButton,
                    isSelected = selectedIndex == index
                )
            }
        }
    }
}