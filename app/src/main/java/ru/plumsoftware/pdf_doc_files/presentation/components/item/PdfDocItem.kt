package ru.plumsoftware.pdf_doc_files.presentation.components.item

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.pdf_doc_files.presentation.model.PdfDocumentModel
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.presentation.components.buttons.MoreButton
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Alpha
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Padding
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Size
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Space
import ru.plumsoftware.pdf_doc_files.presentation.theme.ExtendedTheme
import ru.plumsoftware.pdf_doc_files.presentation.theme.PdfTheme

@Composable
fun PdfDocItem(
    pdfDocumentModel: PdfDocumentModel,
    onClick: () -> Unit,
    onMoreClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val bitmap = BitmapFactory.decodeByteArray(
        pdfDocumentModel.pdfDocumentCover ?: byteArrayOf(),
        0,
        pdfDocumentModel.pdfDocumentCover!!.size
    ).asImageBitmap()
    ExtendedTheme {
        Button(
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .then(modifier),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = ExtendedTheme.extendedColorScheme.cardColor.colorContainer,
                contentColor = ExtendedTheme.extendedColorScheme.cardColor.onColorContainer,
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = Padding.largePadding, vertical = Padding.mediumPadding),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(
                    space = Space.small,
                    alignment = Alignment.Start
                )
            ) {
                Image(
                    bitmap = bitmap,
                    contentDescription = stringResource(id = R.string.pdf_doc_image),
                    modifier = Modifier.size(size = Size.PDfDocCover.size)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        space = Space.small,
                        alignment = Alignment.Top
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1.0f)
                        .padding(horizontal = Padding.smallPadding)
                ) {
                    Text(
                        text = pdfDocumentModel.name ?: "",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "${pdfDocumentModel.pageCount} - ${pdfDocumentModel.memoryValue}",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colorScheme.onBackground.copy(
                                alpha = Alpha.notSelectedAlpha
                            )
                        )
                    )
                    Text(
                        text = "${pdfDocumentModel.lastOpenDate}",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = MaterialTheme.colorScheme.onBackground.copy(
                                alpha = Alpha.notSelectedAlpha
                            )
                        )
                    )
                }

                MoreButton(
                    onClick = onMoreClick
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    locale = "RU"
)
private fun PdfDocItemPreview() {
    PdfTheme {
        Scaffold {
            PdfDocItem(
                pdfDocumentModel = PdfDocumentModel.empty(),
                onClick = {},
                onMoreClick = {}
            )
        }
    }
}