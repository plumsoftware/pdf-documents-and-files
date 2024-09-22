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

public val PdfViewerIconPack.Recent: ImageVector
    get() {
        if (_recent != null) {
            return _recent!!
        }
        _recent = Builder(name = "Recent", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFF62D30)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.7143f, 10.0f)
                curveTo(0.7143f, 11.8366f, 1.2589f, 13.6319f, 2.2792f, 15.1589f)
                curveTo(3.2996f, 16.6859f, 4.7498f, 17.8761f, 6.4465f, 18.5789f)
                curveTo(8.1433f, 19.2817f, 10.0103f, 19.4656f, 11.8116f, 19.1073f)
                curveTo(13.6128f, 18.749f, 15.2674f, 17.8646f, 16.566f, 16.566f)
                curveTo(17.8646f, 15.2674f, 18.749f, 13.6128f, 19.1073f, 11.8116f)
                curveTo(19.4656f, 10.0103f, 19.2817f, 8.1433f, 18.5789f, 6.4465f)
                curveTo(17.8761f, 4.7498f, 16.6859f, 3.2996f, 15.1589f, 2.2792f)
                curveTo(13.6318f, 1.2589f, 11.8365f, 0.7143f, 10.0f, 0.7143f)
                curveTo(7.34f, 0.7114f, 4.7814f, 1.7348f, 2.8572f, 3.5714f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFF62D30)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(3.5714f, 0.7143f)
                lineTo(2.8572f, 3.5714f)
                lineTo(5.7143f, 4.2857f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFF62D30)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.0f, 5.0f)
                verticalLineTo(10.7143f)
                lineTo(6.2857f, 12.5714f)
            }
        }
        .build()
        return _recent!!
    }

private var _recent: ImageVector? = null
