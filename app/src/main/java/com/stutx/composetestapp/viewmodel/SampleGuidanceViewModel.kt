/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composetestapp.viewmodel

import android.util.Log
import com.stutx.composeuilib.v2.data.TextContents
import com.stutx.composeuilib.v2.data.TextContentsRaw
import com.stutx.composeuilib.v3.viewmodel.GuidanceViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SampleGuidanceViewModel() : GuidanceViewModel() {

    override val _guidance: MutableStateFlow<TextContents> = MutableStateFlow(BASE_GUIDANCE)

    init {
        Log.i(TAG, "instantiated")
        Log.i(TAG, "guidance: $guidance")
        Log.i(TAG, "_guidance: $_guidance")
    }

    fun update(data: String) {
        val newDesc = BASE_GUIDANCE.copy(
            description = data
        )
        _guidance.value = newDesc
    }

    companion object {
        private val BASE_GUIDANCE = TextContentsRaw(
            title = "This is sample activity using viewmodel",
            subtitle = "Description area will be updated by click actions",
            description = ""
        )

        private val TAG = SampleGuidanceViewModel::class.java.simpleName
    }
}
