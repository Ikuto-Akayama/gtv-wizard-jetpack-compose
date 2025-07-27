/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.widget

import androidx.annotation.CallSuper
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.stutx.composeuilib.v4.item.ComposableItem
import com.stutx.composeuilib.v4.item.ThumbnailComposableItem

internal object ThumbnailComposable : ComposableView {

    @Composable
    @CallSuper
    override fun Compose(
        modifier: Modifier,
        item: ComposableItem
    ) {
        when (item) {
            is ThumbnailComposableItem.ImageComposableItem -> {
                ComposeImage(
                    modifier = modifier,
                    item = item
                )
            }
            is ThumbnailComposableItem.AnimatedVectorComposableItem -> {
                ComposeAnimatedVector(
                    modifier = modifier,
                    item = item
                )
            }
            is ThumbnailComposableItem.IconComposableItem -> {
                ComposeIcon(
                    modifier = modifier,
                    item = item
                )
            }
            is ThumbnailComposableItem.PredefinedIconComposableItem -> {
                Icon(
                    modifier = modifier,
                    imageVector = item.imageVector,
                    contentDescription = null // Provide a description if needed
                )
            }
            else -> { /* nop */ }
        }
    }

    @Composable
    private fun ComposeImage(
        modifier: Modifier,
        item: ThumbnailComposableItem.ImageComposableItem
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(item.resId),
            contentDescription = null // Provide a description if needed
        )
    }

    @Composable
    private fun ComposeAnimatedVector(
        modifier: Modifier,
        item: ThumbnailComposableItem.AnimatedVectorComposableItem
    ) {
        val image = AnimatedImageVector.animatedVectorResource(item.resId)
        val atEnd by item.animationFlag.collectAsState()
        Image(
            modifier = modifier,
            painter = rememberAnimatedVectorPainter(image, atEnd),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }

    @Composable
    private fun ComposeIcon(
        modifier: Modifier,
        item: ThumbnailComposableItem.IconComposableItem
    ) {
        Icon(
            modifier = modifier,
            painter = painterResource(item.resId),
            contentDescription = null // Provide a description if needed
        )
    }
}
