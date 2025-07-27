/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.item

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v4.widget.WidgetBuilderBase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class ThumbnailComposableItem : ComposableItem {

    // TODO: consider specific case when only resource id is updated.

    /**
     * for normal image resources.
     */
    data class ImageComposableItem(
        @DrawableRes
        val resId: Int,
    ) : ThumbnailComposableItem()

    /**
     * for animated drawable (not lottie animation)
     */
    data class AnimatedVectorComposableItem(
        @DrawableRes
        val resId: Int,
        val animationFlag: StateFlow<Boolean>,
    ) : ThumbnailComposableItem()

    /**
     * for icon resources.
     */
    data class IconComposableItem(
        @DrawableRes
        val resId: Int,
    ) : ThumbnailComposableItem()

    /**
     * See [androidx.compose.material.icons.Icons.Default] for predefined icons.
     */
    data class PredefinedIconComposableItem(
        val imageVector: ImageVector
    ) : ThumbnailComposableItem()
}

@Preview(
    backgroundColor = 0xFFFFFF,
    showBackground = true
)
@Composable
fun PreviewThumbnailComposableItem() {
    WidgetBuilderBase.Compose(
        modifier = Modifier,
        items = listOf(
            ThumbnailComposableItem.ImageComposableItem(resId = R.drawable.baseline_arrow_right_24),
            ThumbnailComposableItem.AnimatedVectorComposableItem(
                resId = R.drawable.avd_anim_minus_to_plus,
                animationFlag = MutableStateFlow(true)
            ),
            ThumbnailComposableItem.IconComposableItem(resId = R.drawable.baseline_arrow_right_24),
            ThumbnailComposableItem.PredefinedIconComposableItem(
                imageVector = Icons.Default.Done
            )
        )
    )
}