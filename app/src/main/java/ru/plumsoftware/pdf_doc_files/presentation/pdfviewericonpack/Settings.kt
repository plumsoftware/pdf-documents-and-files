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

public val PdfViewerIconPack.Settings: ImageVector
    get() {
        if (_settings != null) {
            return _settings!!
        }
        _settings = Builder(name = "Settings", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF6E6E6E)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(7.4714f, 3.2143f)
                lineTo(8.0857f, 1.6286f)
                curveTo(8.1893f, 1.3601f, 8.3716f, 1.1292f, 8.6086f, 0.966f)
                curveTo(8.8457f, 0.8029f, 9.1265f, 0.7151f, 9.4143f, 0.7143f)
                horizontalLineTo(10.5857f)
                curveTo(10.8735f, 0.7151f, 11.1543f, 0.8029f, 11.3914f, 0.966f)
                curveTo(11.6284f, 1.1292f, 11.8107f, 1.3601f, 11.9143f, 1.6286f)
                lineTo(12.5286f, 3.2143f)
                lineTo(14.6143f, 4.4143f)
                lineTo(16.3f, 4.1571f)
                curveTo(16.5807f, 4.1191f, 16.8664f, 4.1653f, 17.1207f, 4.2899f)
                curveTo(17.3751f, 4.4145f, 17.5867f, 4.612f, 17.7286f, 4.8572f)
                lineTo(18.3f, 5.8572f)
                curveTo(18.4464f, 6.1062f, 18.5139f, 6.3938f, 18.4935f, 6.682f)
                curveTo(18.4731f, 6.9702f, 18.3658f, 7.2455f, 18.1857f, 7.4714f)
                lineTo(17.1429f, 8.8f)
                verticalLineTo(11.2f)
                lineTo(18.2143f, 12.5286f)
                curveTo(18.3943f, 12.7545f, 18.5017f, 13.0298f, 18.5221f, 13.318f)
                curveTo(18.5425f, 13.6062f, 18.475f, 13.8938f, 18.3286f, 14.1429f)
                lineTo(17.7571f, 15.1429f)
                curveTo(17.6153f, 15.388f, 17.4037f, 15.5855f, 17.1493f, 15.7101f)
                curveTo(16.8949f, 15.8348f, 16.6093f, 15.881f, 16.3286f, 15.8429f)
                lineTo(14.6429f, 15.5857f)
                lineTo(12.5571f, 16.7857f)
                lineTo(11.9429f, 18.3714f)
                curveTo(11.8393f, 18.6399f, 11.657f, 18.8709f, 11.4199f, 19.034f)
                curveTo(11.1829f, 19.1971f, 10.9021f, 19.2849f, 10.6143f, 19.2857f)
                horizontalLineTo(9.4143f)
                curveTo(9.1265f, 19.2849f, 8.8457f, 19.1971f, 8.6086f, 19.034f)
                curveTo(8.3716f, 18.8709f, 8.1893f, 18.6399f, 8.0857f, 18.3714f)
                lineTo(7.4714f, 16.7857f)
                lineTo(5.3857f, 15.5857f)
                lineTo(3.7f, 15.8429f)
                curveTo(3.4193f, 15.881f, 3.1336f, 15.8348f, 2.8793f, 15.7101f)
                curveTo(2.6249f, 15.5855f, 2.4133f, 15.388f, 2.2714f, 15.1429f)
                lineTo(1.7f, 14.1429f)
                curveTo(1.5536f, 13.8938f, 1.4861f, 13.6062f, 1.5065f, 13.318f)
                curveTo(1.5269f, 13.0298f, 1.6342f, 12.7545f, 1.8143f, 12.5286f)
                lineTo(2.8571f, 11.2f)
                verticalLineTo(8.8f)
                lineTo(1.7857f, 7.4714f)
                curveTo(1.6057f, 7.2455f, 1.4984f, 6.9702f, 1.4779f, 6.682f)
                curveTo(1.4575f, 6.3938f, 1.525f, 6.1062f, 1.6714f, 5.8572f)
                lineTo(2.2429f, 4.8572f)
                curveTo(2.3847f, 4.612f, 2.5963f, 4.4145f, 2.8507f, 4.2899f)
                curveTo(3.1051f, 4.1653f, 3.3907f, 4.1191f, 3.6714f, 4.1571f)
                lineTo(5.3571f, 4.4143f)
                lineTo(7.4714f, 3.2143f)
                close()
                moveTo(7.1429f, 10.0f)
                curveTo(7.1429f, 10.5651f, 7.3104f, 11.1175f, 7.6244f, 11.5874f)
                curveTo(7.9383f, 12.0572f, 8.3845f, 12.4234f, 8.9066f, 12.6397f)
                curveTo(9.4287f, 12.8559f, 10.0032f, 12.9125f, 10.5574f, 12.8023f)
                curveTo(11.1116f, 12.692f, 11.6207f, 12.4199f, 12.0203f, 12.0203f)
                curveTo(12.4199f, 11.6207f, 12.692f, 11.1116f, 12.8022f, 10.5574f)
                curveTo(12.9125f, 10.0032f, 12.8559f, 9.4287f, 12.6397f, 8.9066f)
                curveTo(12.4234f, 8.3846f, 12.0572f, 7.9383f, 11.5873f, 7.6244f)
                curveTo(11.1175f, 7.3104f, 10.5651f, 7.1429f, 10.0f, 7.1429f)
                curveTo(9.2422f, 7.1429f, 8.5155f, 7.4439f, 7.9797f, 7.9797f)
                curveTo(7.4439f, 8.5155f, 7.1429f, 9.2423f, 7.1429f, 10.0f)
                verticalLineTo(10.0f)
                close()
            }
        }
        .build()
        return _settings!!
    }

private var _settings: ImageVector? = null
