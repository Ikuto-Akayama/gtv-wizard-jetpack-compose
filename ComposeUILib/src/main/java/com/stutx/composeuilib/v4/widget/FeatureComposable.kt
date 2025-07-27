/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.widget

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stutx.composeuilib.v4.item.ComposableItem
import com.stutx.composeuilib.v4.item.FeatureComposableItem

internal object FeatureComposable : ComposableView {

    @Composable
    override fun Compose(
        modifier: Modifier,
        item: ComposableItem
    ) {
        if (item !is FeatureComposableItem) return
        LazyRow(
            modifier = modifier,
            horizontalArrangement = item.horizontalArrangement,
            verticalAlignment = item.verticalAlignment,
        ) {
            item {
                ThumbnailComposable.Compose(
                    modifier = modifier,
                    item = item.thumbnail
                )
            }
            item {
                TextComposable.Compose(
                    modifier = modifier,
                    item = item.text
                )
            }
        }
    }
}
