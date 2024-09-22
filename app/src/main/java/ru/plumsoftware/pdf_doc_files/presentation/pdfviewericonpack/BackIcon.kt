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

public val PdfViewerIconPack.BackIcon: ImageVector
    get() {
        if (_backIcon != null) {
            return _backIcon!!
        }
        _backIcon = Builder(name = "BackIcon", defaultWidth = 12.0.dp, defaultHeight = 22.0.dp,
                viewportWidth = 12.0f, viewportHeight = 22.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000001)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.95f, 0.7857f)
                lineTo(1.2857f, 10.45f)
                curveTo(1.2105f, 10.5205f, 1.1506f, 10.6057f, 1.1097f, 10.7003f)
                curveTo(1.0687f, 10.7949f, 1.0476f, 10.8969f, 1.0476f, 11.0f)
                curveTo(1.0476f, 11.1031f, 1.0687f, 11.2051f, 1.1097f, 11.2997f)
                curveTo(1.1506f, 11.3943f, 1.2105f, 11.4794f, 1.2857f, 11.55f)
                lineTo(10.95f, 21.2143f)
            }
        }
        .build()
        return _backIcon!!
    }

private var _backIcon: ImageVector? = null
