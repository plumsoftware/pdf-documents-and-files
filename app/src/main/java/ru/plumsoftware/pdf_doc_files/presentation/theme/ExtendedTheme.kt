package ru.plumsoftware.pdf_doc_files.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColorScheme(
    val extendedGreen1: ColorFamily,
    val extendedBlue1: ColorFamily,
    val cardColor: ColorFamily
)

val extendedLight = ExtendedColorScheme(
    extendedGreen1 = ColorFamily(
        extendedGreen1Light,
        onExtendedGreen1Light,
        extendedGreen1ContainerLight,
        onExtendedGreen1ContainerLight,
    ),
    extendedBlue1 = ColorFamily(
        extendedBlue1Light,
        onExtendedBlue1Light,
        extendedBlue1ContainerLight,
        onExtendedBlue1ContainerLight,
    ),
    cardColor = ColorFamily(
        colorContainer = extendedCardColorLight,
        onColorContainer = extendedOnCardColorLight,
        onColor = extendedOnCardColorLight,
        color = extendedCardColorLight
    )
)

val extendedDark = ExtendedColorScheme(
    extendedGreen1 = ColorFamily(
        extendedGreen1Dark,
        onExtendedGreen1Dark,
        extendedGreen1ContainerDark,
        onExtendedGreen1ContainerDark,
    ),
    extendedBlue1 = ColorFamily(
        extendedBlue1Dark,
        onExtendedBlue1Dark,
        extendedBlue1ContainerDark,
        onExtendedBlue1ContainerDark,
    ),
    cardColor = ColorFamily(
        colorContainer = extendedCardColorDark,
        onColorContainer = extendedOnCardColorDark,
        onColor = extendedOnCardColorDark,
        color = extendedCardColorDark
    )
)

val extendedLightMediumContrast = ExtendedColorScheme(
    extendedGreen1 = ColorFamily(
        extendedGreen1LightMediumContrast,
        onExtendedGreen1LightMediumContrast,
        extendedGreen1ContainerLightMediumContrast,
        onExtendedGreen1ContainerLightMediumContrast,
    ),
    extendedBlue1 = ColorFamily(
        extendedBlue1LightMediumContrast,
        onExtendedBlue1LightMediumContrast,
        extendedBlue1ContainerLightMediumContrast,
        onExtendedBlue1ContainerLightMediumContrast,
    ),
    cardColor = ColorFamily(
        colorContainer = extendedCardColorLight,
        onColorContainer = extendedOnCardColorLight,
        onColor = extendedOnCardColorLight,
        color = extendedCardColorLight
    )
)

val extendedLightHighContrast = ExtendedColorScheme(
    extendedGreen1 = ColorFamily(
        extendedGreen1LightHighContrast,
        onExtendedGreen1LightHighContrast,
        extendedGreen1ContainerLightHighContrast,
        onExtendedGreen1ContainerLightHighContrast,
    ),
    extendedBlue1 = ColorFamily(
        extendedBlue1LightHighContrast,
        onExtendedBlue1LightHighContrast,
        extendedBlue1ContainerLightHighContrast,
        onExtendedBlue1ContainerLightHighContrast,
    ),
    cardColor = ColorFamily(
        colorContainer = extendedCardColorLight,
        onColorContainer = extendedOnCardColorLight,
        onColor = extendedOnCardColorLight,
        color = extendedCardColorLight
    )
)

val extendedDarkMediumContrast = ExtendedColorScheme(
    extendedGreen1 = ColorFamily(
        extendedGreen1DarkMediumContrast,
        onExtendedGreen1DarkMediumContrast,
        extendedGreen1ContainerDarkMediumContrast,
        onExtendedGreen1ContainerDarkMediumContrast,
    ),
    extendedBlue1 = ColorFamily(
        extendedBlue1DarkMediumContrast,
        onExtendedBlue1DarkMediumContrast,
        extendedBlue1ContainerDarkMediumContrast,
        onExtendedBlue1ContainerDarkMediumContrast,
    ),
    cardColor = ColorFamily(
        colorContainer = extendedCardColorDark,
        onColorContainer = extendedOnCardColorDark,
        onColor = extendedOnCardColorDark,
        color = extendedCardColorDark
    )
)

val extendedDarkHighContrast = ExtendedColorScheme(
    extendedGreen1 = ColorFamily(
        extendedGreen1DarkHighContrast,
        onExtendedGreen1DarkHighContrast,
        extendedGreen1ContainerDarkHighContrast,
        onExtendedGreen1ContainerDarkHighContrast,
    ),
    extendedBlue1 = ColorFamily(
        extendedBlue1DarkHighContrast,
        onExtendedBlue1DarkHighContrast,
        extendedBlue1ContainerDarkHighContrast,
        onExtendedBlue1ContainerDarkHighContrast,
    ),
    cardColor = ColorFamily(
        colorContainer = extendedCardColorDark,
        onColorContainer = extendedOnCardColorDark,
        onColor = extendedOnCardColorDark,
        color = extendedCardColorDark
    )
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified
)

@SuppressLint("ComposeCompositionLocalUsage")
val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColorScheme(
        extendedGreen1 = unspecified_scheme,
        extendedBlue1 = unspecified_scheme,
        cardColor = unspecified_scheme
    )
}

object ExtendedTheme {
    val extendedColorScheme: ExtendedColorScheme
        @Composable
        get() = LocalExtendedColors.current
}

@Composable
fun ExtendedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = when (darkTheme) {
        true -> extendedDark
        false -> extendedLight
    }

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            content = content
        )
    }
}