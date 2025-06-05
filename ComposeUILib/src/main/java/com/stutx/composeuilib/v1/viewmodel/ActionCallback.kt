/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v1.viewmodel

import androidx.annotation.StringRes

interface ActionCallback {
    fun onSelected(@StringRes id: Int)
}
