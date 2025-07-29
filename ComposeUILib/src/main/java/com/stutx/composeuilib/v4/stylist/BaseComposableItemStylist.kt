/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v4.stylist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.stutx.composeuilib.v4.item.ComposableItem
import kotlinx.coroutines.flow.MutableStateFlow

class BaseComposableItemStylist : ComposableItemStylist {
    val guidanceItems = MutableStateFlow<List<ComposableItem>>(emptyList())
    val actionItems = MutableStateFlow<List<ComposableItem>>(emptyList())

    @Composable
    override fun Compose() {
        val guidance by guidanceItems.collectAsState()
        val action by actionItems.collectAsState()
    }
}