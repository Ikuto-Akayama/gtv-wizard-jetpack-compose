/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v4.item.ComposableItem
import com.stutx.composeuilib.v4.item.FeatureComposableItem
import com.stutx.composeuilib.v4.item.TextComposableItem
import com.stutx.composeuilib.v4.item.ThumbnailComposableItem

internal object WidgetBuilderBase : WidgetBuilder {

    @Composable
    override fun Compose(modifier: Modifier, items: List<ComposableItem>) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        ) {
            items(items.size) { index ->
                val item = items[index]
                ComposeWidget(modifier, item)
            }
        }
    }

    // TODO: implement more smart.
    @Composable
    private fun ComposeWidget(modifier: Modifier, item: ComposableItem) {
        when (item) {
            is ThumbnailComposableItem -> {
                ThumbnailComposable.Compose(modifier, item)
            }
            is TextComposableItem -> {
                TextComposable.Compose(modifier, item)
            }
            is FeatureComposableItem -> {
                FeatureComposable.Compose(modifier, item)
            }
            else -> { /* nop */ }
        }
    }
}

@Preview(
    backgroundColor = 0xFFFFFF,
    showBackground = true
)
@Composable
fun PreviewWidgetBuilder() {
    WidgetBuilderBase.Compose(
        modifier = Modifier,
        items = listOf(
            TextComposableItem.LegacyTitleText("Title String"),
            TextComposableItem.LegacyDescriptionText("This is description String."),
            ThumbnailComposableItem.ImageComposableItem(
                resId = R.drawable.baseline_arrow_right_24
            ),
            FeatureComposableItem(
                ThumbnailComposableItem.IconComposableItem(
                    resId = R.drawable.baseline_arrow_right_24
                ),
                TextComposableItem.LegacyDescriptionText("This is description String.\nTooooooooo long text")
            ),
        )
    )
}