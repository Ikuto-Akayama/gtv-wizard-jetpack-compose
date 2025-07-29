/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.stutx.composeuilib.v4.widget.BaseWidgetBuilder

sealed class TextComposableItem : ComposableItem {

    // TODO: consider specific case when text is updated.

    data class LegacyTitleText(val text: String) : TextComposableItem()

    /**
     * note: spannableText can be made by using [androidx.compose.ui.text.buildAnnotatedString]
     */
    data class SpannableTitleText(
        val spannableText: AnnotatedString,
        val inlineContent: Map<String, InlineTextContent> = emptyMap(),
    ) : TextComposableItem()

    data class LegacyDescriptionText(val text: String) : TextComposableItem()

    /**
     * note: spannableText can be made by using [androidx.compose.ui.text.buildAnnotatedString]
     */
    data class SpannableDescriptionText(
        val spannableText: AnnotatedString,
        val inlineContent: Map<String, InlineTextContent> = emptyMap(),
    ) : TextComposableItem()
}

@Preview(
    backgroundColor = 0xFFFFFF,
    showBackground = true
)
@Composable
fun PreviewTextComposableItem() = BaseWidgetBuilder.Compose(
    modifier = Modifier,
    items = listOf(
        TextComposableItem.LegacyTitleText("Title String"),
        TextComposableItem.LegacyDescriptionText("This is description String."),
        TextComposableItem.SpannableTitleText(
            buildAnnotatedString {
                val spannableTextStyle = SpanStyle(
                    color = MaterialTheme.colorScheme.error
                )
                withStyle(spannableTextStyle) {
                    append("S")
                }
                append("pannable ")
                withStyle(spannableTextStyle) {
                    append("T")
                }
                append("itle")
            }
        ),
        TextComposableItem.SpannableDescriptionText(
            spannableText = buildAnnotatedString {
                append("This is text with a ")
                appendInlineContent(id = "imageId")
                append(" icon")
            },
            inlineContent = mapOf(
                "imageId" to InlineTextContent(
                    Placeholder(
                        width = 24.sp,
                        height = 24.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                    )
                ) {
                    Image(
                        imageVector = Icons.Default.Phone,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = null
                    )
                }
            )
        ),
    )
)