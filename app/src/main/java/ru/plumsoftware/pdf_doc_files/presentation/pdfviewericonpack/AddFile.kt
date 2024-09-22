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

public val PdfViewerIconPack.AddFile: ImageVector
    get() {
        if (_addFile != null) {
            return _addFile!!
        }
        _addFile = Builder(name = "AddFile", defaultWidth = 22.0.dp, defaultHeight = 22.0.dp,
                viewportWidth = 22.0f, viewportHeight = 22.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(3.9341f, 8.5495f)
                verticalLineTo(2.3956f)
                curveTo(3.9341f, 1.9876f, 4.0961f, 1.5963f, 4.3847f, 1.3077f)
                curveTo(4.6732f, 1.0192f, 5.0645f, 0.8571f, 5.4725f, 0.8571f)
                horizontalLineTo(13.1648f)
                lineTo(20.8571f, 8.5495f)
                verticalLineTo(19.3187f)
                curveTo(20.8571f, 19.7267f, 20.6951f, 20.118f, 20.4065f, 20.4065f)
                curveTo(20.118f, 20.6951f, 19.7267f, 20.8571f, 19.3187f, 20.8571f)
                horizontalLineTo(11.6264f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.1648f, 0.8571f)
                verticalLineTo(8.5494f)
                horizontalLineTo(20.8571f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.4725f, 11.6264f)
                verticalLineTo(20.8571f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.8571f, 16.2418f)
                horizontalLineTo(10.0879f)
            }
        }
        .build()
        return _addFile!!
    }

private var _addFile: ImageVector? = null
