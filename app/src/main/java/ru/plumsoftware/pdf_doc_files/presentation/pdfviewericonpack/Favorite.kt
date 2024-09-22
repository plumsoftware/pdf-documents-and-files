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

public val PdfViewerIconPack.Favorite: ImageVector
    get() {
        if (_favorite != null) {
            return _favorite!!
        }
        _favorite = Builder(name = "Favorite", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF6E6E6E)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.7f, 1.5571f)
                lineTo(12.9714f, 6.1428f)
                curveTo(13.0231f, 6.2592f, 13.1044f, 6.3601f, 13.2071f, 6.4352f)
                curveTo(13.3099f, 6.5104f, 13.4306f, 6.5574f, 13.5571f, 6.5714f)
                lineTo(18.5714f, 7.3143f)
                curveTo(18.7166f, 7.3329f, 18.8535f, 7.3925f, 18.9661f, 7.4861f)
                curveTo(19.0787f, 7.5796f, 19.1623f, 7.7033f, 19.2073f, 7.8426f)
                curveTo(19.2522f, 7.9819f, 19.2566f, 8.1311f, 19.2199f, 8.2728f)
                curveTo(19.1832f, 8.4145f, 19.1069f, 8.5429f, 19.0f, 8.6428f)
                lineTo(15.3857f, 12.2286f)
                curveTo(15.2935f, 12.3147f, 15.2242f, 12.4226f, 15.1843f, 12.5424f)
                curveTo(15.1444f, 12.6621f, 15.1351f, 12.79f, 15.1571f, 12.9143f)
                lineTo(16.0286f, 17.9571f)
                curveTo(16.0538f, 18.102f, 16.0379f, 18.2511f, 15.9825f, 18.3874f)
                curveTo(15.9272f, 18.5237f, 15.8348f, 18.6417f, 15.7157f, 18.728f)
                curveTo(15.5966f, 18.8144f, 15.4557f, 18.8655f, 15.309f, 18.8757f)
                curveTo(15.1622f, 18.8859f, 15.0156f, 18.8547f, 14.8857f, 18.7857f)
                lineTo(10.3714f, 16.4f)
                curveTo(10.2558f, 16.3432f, 10.1288f, 16.3137f, 10.0f, 16.3137f)
                curveTo(9.8712f, 16.3137f, 9.7442f, 16.3432f, 9.6286f, 16.4f)
                lineTo(5.1143f, 18.7857f)
                curveTo(4.9844f, 18.8547f, 4.8378f, 18.8859f, 4.691f, 18.8757f)
                curveTo(4.5443f, 18.8655f, 4.4034f, 18.8144f, 4.2843f, 18.728f)
                curveTo(4.1652f, 18.6417f, 4.0728f, 18.5237f, 4.0175f, 18.3874f)
                curveTo(3.9622f, 18.2511f, 3.9462f, 18.102f, 3.9714f, 17.9571f)
                lineTo(4.8429f, 12.8571f)
                curveTo(4.865f, 12.7328f, 4.8556f, 12.605f, 4.8157f, 12.4852f)
                curveTo(4.7758f, 12.3655f, 4.7065f, 12.2576f, 4.6143f, 12.1714f)
                lineTo(0.9571f, 8.6428f)
                curveTo(0.849f, 8.5401f, 0.7729f, 8.4082f, 0.7381f, 8.2632f)
                curveTo(0.7033f, 8.1181f, 0.7114f, 7.966f, 0.7613f, 7.8254f)
                curveTo(0.8112f, 7.6848f, 0.9008f, 7.5617f, 1.0192f, 7.471f)
                curveTo(1.1376f, 7.3802f, 1.2798f, 7.3258f, 1.4286f, 7.3143f)
                lineTo(6.4429f, 6.5714f)
                curveTo(6.5694f, 6.5574f, 6.6901f, 6.5104f, 6.7929f, 6.4352f)
                curveTo(6.8956f, 6.3601f, 6.9769f, 6.2592f, 7.0286f, 6.1428f)
                lineTo(9.3f, 1.5571f)
                curveTo(9.3619f, 1.4236f, 9.4606f, 1.3105f, 9.5847f, 1.2313f)
                curveTo(9.7087f, 1.152f, 9.8528f, 1.1099f, 10.0f, 1.1099f)
                curveTo(10.1472f, 1.1099f, 10.2913f, 1.152f, 10.4153f, 1.2313f)
                curveTo(10.5394f, 1.3105f, 10.6381f, 1.4236f, 10.7f, 1.5571f)
                verticalLineTo(1.5571f)
                close()
            }
        }
        .build()
        return _favorite!!
    }

private var _favorite: ImageVector? = null
