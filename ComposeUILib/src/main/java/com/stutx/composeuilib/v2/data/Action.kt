/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

sealed class Action(open val id: Int) {
    @Composable
    abstract fun getTitle(): String?
    @Composable
    abstract fun getSubtitle(): String?
    @Composable
    abstract fun getIcon(): Painter?
}

data class ActionRes(
    override val id: Int,
    @StringRes val title: Int? = null,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val icon: Int? = null,
) : Action(id) {

    @Composable
    override fun getTitle(): String? {
        return title?.let {
            stringResource(it)
        }
    }

    @Composable
    override fun getSubtitle(): String? {
        return subtitle?.let {
            stringResource(it)
        }
    }

    @Composable
    override fun getIcon(): Painter? {
        return icon?.let {
            painterResource(it)
        }
    }
}

data class ActionRaw(
    override val id: Int,
    val title: String? = null,
    val subtitle: String? = null,
    val icon: Int? = null
) : Action(id) {
    @Composable
    override fun getTitle(): String? = title

    @Composable
    override fun getSubtitle(): String? = subtitle

    @Composable
    override fun getIcon(): Painter? {
        return icon?.let {
            painterResource(it)
        }
    }
}
