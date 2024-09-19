package ru.plumsoftware.pdf_doc_files.presentation.theme

import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import racra.compose.smooth_corner_rect_library.AbsoluteSmoothCornerShape

val appShapes = Shapes(
    extraLarge = AbsoluteSmoothCornerShape(cornerRadius = 24.dp, smoothnessAsPercent = 60),
    large = AbsoluteSmoothCornerShape(cornerRadius = 20.dp, smoothnessAsPercent = 60),
    medium = AbsoluteSmoothCornerShape(cornerRadius = 16.dp, smoothnessAsPercent = 60),
    small = AbsoluteSmoothCornerShape(cornerRadius = 12.dp, smoothnessAsPercent = 60),
    extraSmall = AbsoluteSmoothCornerShape(cornerRadius = 8.dp, smoothnessAsPercent = 60)
)