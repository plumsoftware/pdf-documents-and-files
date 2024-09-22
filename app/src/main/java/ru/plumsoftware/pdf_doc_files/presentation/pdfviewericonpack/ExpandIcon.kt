package ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val PdfViewerIconPack.ExpandIcon: ImageVector
    get() {
        if (_expandIcon != null) {
            return _expandIcon!!
        }
        _expandIcon = Builder(name = "ExpandIcon", defaultWidth = 14.0.dp, defaultHeight = 8.0.dp,
                viewportWidth = 14.0f, viewportHeight = 8.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000001)),
                    strokeLineWidth = 1.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.5f, 0.85f)
                lineTo(6.65f, 7.0f)
                curveTo(6.6949f, 7.0478f, 6.7491f, 7.086f, 6.8093f, 7.112f)
                curveTo(6.8695f, 7.1381f, 6.9344f, 7.1515f, 7.0f, 7.1515f)
                curveTo(7.0656f, 7.1515f, 7.1305f, 7.1381f, 7.1907f, 7.112f)
                curveTo(7.2509f, 7.086f, 7.3051f, 7.0478f, 7.35f, 7.0f)
                lineTo(13.5f, 0.85f)
            }
        }
        .build()
        return _expandIcon!!
    }

private var _expandIcon: ImageVector? = null
