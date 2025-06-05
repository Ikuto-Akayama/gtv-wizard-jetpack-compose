/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.viewmodel

import com.stutx.composeuilib.v2.data.Action

interface ActionCallback {
    fun onSelected(action: Action)
}
