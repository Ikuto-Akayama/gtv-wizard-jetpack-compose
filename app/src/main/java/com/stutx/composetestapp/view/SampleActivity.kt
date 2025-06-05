/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composetestapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.stutx.composetestapp.R
import com.stutx.composetestapp.view.ui.theme.ComposeTestAppTheme
import com.stutx.composeuilib.v2.data.Action
import com.stutx.composeuilib.v2.data.ActionRaw
import com.stutx.composeuilib.v2.data.ActionRes
import com.stutx.composeuilib.v2.data.TextContentsRaw
import com.stutx.composeuilib.v2.view.TwoColumnWizard
import com.stutx.composeuilib.v2.viewmodel.ActionCallback

class SampleActivity : ComponentActivity() {

    private val callback = object : ActionCallback {
        override fun onSelected(action: Action) {
            val context = this@SampleActivity.applicationContext
            Toast.makeText(
                context,
                "${action.id} is selected.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private val actionList = listOf(
        ActionRes(
            id = 0,
            title = R.string.label_action_button_1),
        ActionRes(
            id = 1,
            title = R.string.label_action_button_2,
            icon = com.stutx.composeuilib.R.drawable.baseline_arrow_right_24
        ),
        ActionRes(
            id = 2,
            title = R.string.label_action_button_3
        ),
        ActionRaw(
            id = 3,
            title = "Action Button 4",
            subtitle = "This is raw version",
            icon = com.stutx.composeuilib.R.drawable.baseline_arrow_right_24
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestAppTheme {
                TwoColumnWizard(
                    contents = TextContentsRaw(
                        title = "test title",
                        subtitle = "test subtitle",
                        description = "this is description!!!! toooooooooooooooooooooooo long text can set this. also line break is automatically",
                    ),
                    actions = actionList,
                    actionCallback = callback,
                    modifier = Modifier
                )
            }
        }
    }
}
