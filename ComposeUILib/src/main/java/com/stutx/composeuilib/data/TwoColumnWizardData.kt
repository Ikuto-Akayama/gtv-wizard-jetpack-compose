/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TwoColumnWizardData(
    @StringRes val title: Int,
    @StringRes val subtitle: Int?,
    @StringRes val description: Int,
    val extra: TwoColumnWizardExtra?,
)

data class TwoColumnWizardExtra(
    @DrawableRes val icon: Int? = null,
    @StringRes val label: Int? = null,
    @StringRes val subtitle: Int? = null,
)
