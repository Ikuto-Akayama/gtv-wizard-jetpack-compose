/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stutx.composeuilib.v4.item.ComposableItem

interface ComposableView {
    /**
     * Compose the view.
     */
    @Composable
    fun Compose(modifier: Modifier, item: ComposableItem)
}
