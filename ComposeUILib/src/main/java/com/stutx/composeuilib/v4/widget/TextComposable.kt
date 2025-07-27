/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.widget

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.stutx.composeuilib.v4.item.ComposableItem
import com.stutx.composeuilib.v4.item.TextComposableItem

internal object TextComposable : ComposableView {

    @Composable
    override fun Compose(
        modifier: Modifier,
        item: ComposableItem
    ) {
        when (item) {
            is TextComposableItem.LegacyTitleText -> {
                ComposeLegacyText(
                    modifier = modifier,
                    text = item.text,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            is TextComposableItem.SpannableTitleText -> {
                ComposeSpannableText(
                    modifier = modifier,
                    spannableText = item.spannableText,
                    inlineContent = item.inlineContent,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            is TextComposableItem.LegacyDescriptionText -> {
                ComposeLegacyText(
                    modifier = modifier,
                    text = item.text,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            is TextComposableItem.SpannableDescriptionText -> {
                ComposeSpannableText(
                    modifier = modifier,
                    spannableText = item.spannableText,
                    inlineContent = item.inlineContent,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            else -> { /* nop */ }
        }
    }

    @Composable
    private fun ComposeLegacyText(
        modifier: Modifier,
        text: String,
        style: TextStyle,
    ) {
        Text(
            text = text,
            modifier = modifier,
            style = style,
        )
    }

    @Composable
    private fun ComposeSpannableText(
        modifier: Modifier,
        spannableText: AnnotatedString,
        inlineContent: Map<String, InlineTextContent>,
        style: TextStyle,
    ) {
        Text(
            text = spannableText,
            inlineContent = inlineContent,
            modifier = modifier,
            style = style,
        )
    }
}
