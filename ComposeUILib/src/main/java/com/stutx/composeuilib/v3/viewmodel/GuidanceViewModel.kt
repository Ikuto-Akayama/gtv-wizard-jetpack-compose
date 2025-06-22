/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v3.viewmodel

import androidx.lifecycle.ViewModel
import com.stutx.composeuilib.v2.data.TextContents
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class GuidanceViewModel : ViewModel() {

    /** basic functions */
    abstract protected val _guidance : MutableStateFlow<TextContents>
    val guidance: StateFlow<TextContents>
        get() = _guidance
}
