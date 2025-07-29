/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.stylist

import androidx.compose.runtime.Composable
import com.stutx.composeuilib.v4.item.ComposableItem
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * ComposableItemStylist is a stylist for Composable items.
 */
interface ComposableItemStylist {

    @Composable
    fun Compose()
}
