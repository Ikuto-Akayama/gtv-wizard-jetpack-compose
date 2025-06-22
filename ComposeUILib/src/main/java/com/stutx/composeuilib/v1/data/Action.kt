/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v1.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

@Deprecated("Use v2")
data class Action(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val icon: Int? = null,
)
