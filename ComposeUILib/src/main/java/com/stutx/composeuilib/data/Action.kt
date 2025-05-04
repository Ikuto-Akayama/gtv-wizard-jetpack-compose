/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Action(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val icon: Int? = null,
)
