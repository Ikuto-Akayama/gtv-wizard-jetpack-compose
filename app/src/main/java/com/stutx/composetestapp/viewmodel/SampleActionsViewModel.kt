/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composetestapp.viewmodel

import android.util.Log
import com.stutx.composeuilib.v2.data.Action
import com.stutx.composeuilib.v2.data.ActionRaw
import com.stutx.composeuilib.v3.viewmodel.ActionListener
import com.stutx.composeuilib.v3.viewmodel.ActionsViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SampleActionsViewModel() : ActionsViewModel() {

    override val _actions: MutableStateFlow<List<Action>> =
        MutableStateFlow(
            listOf(
                ActionRaw(
                    id = 0,
                    title = "Button1"
                ),
                ActionRaw(
                    id = 1,
                    title = "Button2"
                ),
                ActionRaw(
                    id = 2,
                    title = "Button3"
                )
            )
        )

    override val actionListener = object : ActionListener {
        override fun onClicked(action: Action) {
            _clickedAction.value = action
        }

        override fun onFocused(action: Action) {
            _focusedAction.value = action
        }
    }

    private val _clickedAction = MutableStateFlow(_actions.value.first())
    val clickedAction: StateFlow<Action> = _clickedAction

    private val _focusedAction = MutableStateFlow(_actions.value.first())
    val focusedAction: StateFlow<Action> = _focusedAction

    init {
        Log.i(TAG, "instantiated")
        Log.i(TAG, "action: $actions")
        Log.i(TAG, "_action: $_actions")
    }

    companion object {
        private val TAG = SampleActionsViewModel::class.java.simpleName
    }
}
