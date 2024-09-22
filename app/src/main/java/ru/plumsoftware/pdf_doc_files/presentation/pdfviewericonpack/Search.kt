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

public val PdfViewerIconPack.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(name = "Search", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.4571f, 16.2f)
                curveTo(12.7334f, 16.2f, 16.2f, 12.7334f, 16.2f, 8.4572f)
                curveTo(16.2f, 4.1809f, 12.7334f, 0.7143f, 8.4571f, 0.7143f)
                curveTo(4.1809f, 0.7143f, 0.7143f, 4.1809f, 0.7143f, 8.4572f)
                curveTo(0.7143f, 12.7334f, 4.1809f, 16.2f, 8.4571f, 16.2f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.2857f, 19.2857f)
                lineTo(13.9286f, 13.9286f)
            }
        }
        .build()
        return _search!!
    }

private var _search: ImageVector? = null
