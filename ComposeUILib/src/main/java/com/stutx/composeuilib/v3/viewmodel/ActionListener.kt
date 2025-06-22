/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v3.viewmodel

import com.stutx.composeuilib.v2.data.Action

interface ActionListener {
    fun onClicked(action: Action)
    fun onFocused(action: Action)
}
