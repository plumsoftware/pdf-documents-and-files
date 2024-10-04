package ru.plumsoftware.pdf_doc_files.presentation.components.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.BottomBarButton
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Blur
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Padding
import ru.plumsoftware.pdf_doc_files.presentation.model.BottomBarButton
import ru.plumsoftware.pdf_doc_files.presentation.theme.ExtendedTheme

@Composable
fun PdfBottomBar(navHost: NavHostController, modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val bottomBarButtons = arrayOf(
        BottomBarButton.RecentButtonBottomBar,
        BottomBarButton.FavouritesButtonBottomBar,
        BottomBarButton.SettingsButtonBottomBar,
    )
    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }
    val localDensity = LocalDensity.current

    Card(
        modifier = Modifier
            .padding(
                start = Padding.largePadding,
                end = Padding.largePadding,
                bottom = Padding.smallPadding
            )
            .then(modifier),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = ExtendedTheme.extendedColorScheme.cardColor.onColorContainer
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .onGloballyPositioned { coordinates ->
                    columnHeightDp = with(localDensity) { coordinates.size.height.toDp() }
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = columnHeightDp)
                    .background(color = ExtendedTheme.extendedColorScheme.cardColor.colorContainer)
                    .blur(radius = Blur.mediumBlur)
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = Padding.mediumPadding, vertical = Padding.smallPadding)
                    .background(color = Color.Transparent)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                bottomBarButtons.forEachIndexed { index, bottomBarButton ->
                    BottomBarButton(
                        onClick = {
                            selectedIndex = index
                            navHost.navigate(route = bottomBarButton.route)
                        },
                        bottomBarButton = bottomBarButton,
                        isSelected = selectedIndex == index
                    )
                }
            }
        }
    }
}