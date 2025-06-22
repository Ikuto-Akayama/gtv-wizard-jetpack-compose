/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v3.viewmodel

import androidx.lifecycle.ViewModel
import com.stutx.composeuilib.v2.data.Action
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class ActionsViewModel : ViewModel() {

    /** basic functions */
    abstract protected val _actions : MutableStateFlow<List<Action>>
    val actions: StateFlow<List<Action>>
        get() = _actions

    abstract val actionListener: ActionListener

    /** attributes */
    open val initialActionFocus = -1
}
