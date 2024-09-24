package ru.plumsoftware.pdf_doc_files.presentation.components.item

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.pdf_doc_files.R
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Padding
import ru.plumsoftware.pdf_doc_files.presentation.dimensions.Space
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.ExpandIcon
import ru.plumsoftware.pdf_doc_files.presentation.pdfviewericonpack.PdfViewerIconPack
import ru.plumsoftware.pdf_doc_files.presentation.theme.ExtendedTheme
import ru.plumsoftware.pdf_doc_files.presentation.theme.PdfTheme

@Composable
fun SettingsItem(selectedTheme: String, modifier: Modifier = Modifier) {

    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = ExtendedTheme.extendedColorScheme.cardColor.colorContainer,
            contentColor = ExtendedTheme.extendedColorScheme.cardColor.onColorContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.largePadding, vertical = Padding.smallPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.theme_change),
                style = MaterialTheme.typography.titleSmall,
            )
            Spacer(modifier = Modifier.weight(weight = 1.0f))
            Button(
                onClick = {
                    isExpanded = !isExpanded
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = ExtendedTheme.extendedColorScheme.cardColor.onColorContainer
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = Space.extraSmall,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    Text(
                        text = selectedTheme,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Icon(
                        imageVector = PdfViewerIconPack.ExpandIcon,
                        contentDescription = stringResource(id = R.string.theme_change_content_desc),
                    )
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    locale = "RU"
)
private fun SettingsItemPreviewDark() {
    ExtendedTheme {
        PdfTheme {
            Scaffold {
                SettingsItem(selectedTheme = stringArrayResource(id = R.array.themes)[0])
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    locale = "RU"
)
private fun SettingsItemPreviewLight() {
    ExtendedTheme {
        PdfTheme {
            Scaffold {
                SettingsItem(selectedTheme = stringArrayResource(id = R.array.themes)[0])
            }
        }
    }
}