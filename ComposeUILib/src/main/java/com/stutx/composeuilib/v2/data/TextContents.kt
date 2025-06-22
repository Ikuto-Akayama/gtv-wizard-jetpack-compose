/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.data

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

interface TextContents {
    @Composable
    fun getTitle(): String?
    @Composable
    fun getSubtitle(): String?
    @Composable
    fun getDescription(): String?
}

data class TextContentsRes(
    @StringRes val title: Int? = null,
    @StringRes val subtitle: Int? = null,
    @StringRes val description: Int? = null,
) : TextContents {
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
    override fun getDescription(): String? {
        return description?.let {
            stringResource(it)
        }
    }

}

data class TextContentsRaw(
    val title: String? = null,
    val subtitle: String? = null,
    val description: String? = null,
) : TextContents {
    @Composable
    override fun getTitle(): String? = title

    @Composable
    override fun getSubtitle(): String? = subtitle

    @Composable
    override fun getDescription(): String? = description
}
