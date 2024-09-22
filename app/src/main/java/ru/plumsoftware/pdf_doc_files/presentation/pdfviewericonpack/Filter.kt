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

public val PdfViewerIconPack.Filter: ImageVector
    get() {
        if (_filter != null) {
            return _filter!!
        }
        _filter = Builder(name = "Filter", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.2857f, 0.7143f)
                horizontalLineTo(0.7143f)
                curveTo(0.7151f, 2.8051f, 1.4204f, 4.8346f, 2.7164f, 6.4753f)
                curveTo(4.0123f, 8.116f, 5.8234f, 9.2722f, 7.8571f, 9.7571f)
                verticalLineTo(19.2857f)
                lineTo(12.1429f, 16.4286f)
                verticalLineTo(9.7571f)
                curveTo(14.1766f, 9.2722f, 15.9877f, 8.116f, 17.2836f, 6.4753f)
                curveTo(18.5796f, 4.8346f, 19.2849f, 2.8051f, 19.2857f, 0.7143f)
                close()
            }
        }
        .build()
        return _filter!!
    }

private var _filter: ImageVector? = null
