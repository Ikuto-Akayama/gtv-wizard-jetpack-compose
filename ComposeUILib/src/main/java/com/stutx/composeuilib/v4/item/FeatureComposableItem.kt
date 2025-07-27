/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v4.widget.WidgetBuilderBase

data class FeatureComposableItem(
    val thumbnail: ThumbnailComposableItem,
    val text: TextComposableItem,
    val horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(4.dp),
    val verticalAlignment: Alignment.Vertical = Alignment.Top,
) : ComposableItem

@Preview(
    backgroundColor = 0xFFFFFF,
    showBackground = true
)
@Composable
fun PreviewFeatureComposableItem() {
    WidgetBuilderBase.Compose(
        modifier = Modifier,
        items = listOf(
            FeatureComposableItem(
                thumbnail = ThumbnailComposableItem.ImageComposableItem(
                    resId = R.drawable.baseline_arrow_right_24
                ),
                text = TextComposableItem.LegacyDescriptionText(text = "Feature Item 1")
            ),
            FeatureComposableItem(
                thumbnail = ThumbnailComposableItem.PredefinedIconComposableItem(
                    imageVector = Icons.Default.Done
                ),
                text = TextComposableItem.SpannableDescriptionText(
                    spannableText = buildAnnotatedString {
                        append("Feature Item 2 with icon: ")
                        appendInlineContent("image")
                        appendLine()
                        appendLine("Too long text can be appendable.\n3rd line is here.")
                        append("4th line text.")
                    },
                    inlineContent = mapOf(
                        "image" to InlineTextContent(
                            placeholder = Placeholder(
                                width = 24.sp,
                                height = 24.sp,
                                placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddCircle,
                                contentDescription = null,
                                modifier = Modifier,
                            )
                        },
                    )
                )
            )
        )
    )
}