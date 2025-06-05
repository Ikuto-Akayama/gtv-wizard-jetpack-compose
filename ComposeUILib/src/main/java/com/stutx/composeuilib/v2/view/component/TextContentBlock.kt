/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.view.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v2.data.TextContents
import com.stutx.composeuilib.v2.data.TextContentsRaw
import com.stutx.composeuilib.v2.data.TextContentsRes

@Composable
fun TextContentBlock(
    contents: TextContents,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
    ) {
        /** title and subtitle */
        if (contents.getTitle() != null || contents.getSubtitle() != null) {
            Heading(contents, modifier)
        }
        /** descriptions */
        contents.getDescription()?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineBreak = LineBreak.Paragraph
                ),
                modifier = modifier
            )
        }
    }
}

@Composable
private fun Heading(
    contents: TextContents,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start
    ) {
        contents.getTitle()?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.headlineMedium,
                modifier = modifier,
            )
        }
        contents.getSubtitle()?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier
            )
        }
    }
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "TextContentBlock preview(raw)",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun TextContentBlockPreview1() {
    TextContentBlock(
        contents = TextContentsRaw(
            title = "test title",
            subtitle = "test subtitle",
            description = "this is description!!!!",
        ),
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "TextContentBlock preview(res)",
)
@Composable
private fun TextContentBlockPreview2() {
    TextContentBlock(
        contents = TextContentsRes(
            title = R.string.label_dialog_title,
            subtitle = R.string.label_dialog_subtitle,
            description = R.string.label_dialog_description
        ),
        modifier = Modifier
    )
}
