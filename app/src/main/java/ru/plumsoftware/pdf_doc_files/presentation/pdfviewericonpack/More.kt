package ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val PdfViewerIconPack.More: ImageVector
    get() {
        if (_more != null) {
            return _more!!
        }
        _more = Builder(name = "More", defaultWidth = 6.0.dp, defaultHeight = 21.0.dp, viewportWidth
                = 6.0f, viewportHeight = 21.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.0f, 5.5f)
                curveTo(4.3018f, 5.5f, 5.3571f, 4.4447f, 5.3571f, 3.1428f)
                curveTo(5.3571f, 1.841f, 4.3018f, 0.7857f, 3.0f, 0.7857f)
                curveTo(1.6982f, 0.7857f, 0.6429f, 1.841f, 0.6429f, 3.1428f)
                curveTo(0.6429f, 4.4447f, 1.6982f, 5.5f, 3.0f, 5.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.0f, 13.2143f)
                curveTo(4.3018f, 13.2143f, 5.3571f, 12.159f, 5.3571f, 10.8571f)
                curveTo(5.3571f, 9.5553f, 4.3018f, 8.5f, 3.0f, 8.5f)
                curveTo(1.6982f, 8.5f, 0.6429f, 9.5553f, 0.6429f, 10.8571f)
                curveTo(0.6429f, 12.159f, 1.6982f, 13.2143f, 3.0f, 13.2143f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.0f, 20.9286f)
                curveTo(4.3018f, 20.9286f, 5.3571f, 19.8733f, 5.3571f, 18.5714f)
                curveTo(5.3571f, 17.2696f, 4.3018f, 16.2143f, 3.0f, 16.2143f)
                curveTo(1.6982f, 16.2143f, 0.6429f, 17.2696f, 0.6429f, 18.5714f)
                curveTo(0.6429f, 19.8733f, 1.6982f, 20.9286f, 3.0f, 20.9286f)
                close()
            }
        }
        .build()
        return _more!!
    }

private var _more: ImageVector? = null
