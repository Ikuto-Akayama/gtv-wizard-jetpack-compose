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
import com.stutx.composeuilib.data.Action
import com.stutx.composeuilib.data.TwoColumnWizardData
import com.stutx.composeuilib.view.TwoColumnWizard
import com.stutx.composeuilib.viewmodel.ActionCallback

class SampleActivity : ComponentActivity() {

    private val callback = object : ActionCallback {
        override fun onSelected(id: Int) {
            val context = this@SampleActivity.applicationContext
            Toast.makeText(
                context,
                "${context.getText(id)} is selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private val actionList = listOf(
        Action(R.string.label_action_button_1),
        Action(
            title = R.string.label_action_button_2,
            icon = com.stutx.composeuilib.R.drawable.baseline_arrow_right_24
        ),
        Action(R.string.label_action_button_3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestAppTheme {
                TwoColumnWizard(
                    modifier = Modifier,
                    data = TwoColumnWizardData(
                        title = R.string.label_title_activity_sample,
                        subtitle = R.string.label_subtitle_activity_sample,
                        description = R.string.label_description_activity_sample,
                        extra = null
                    ),
                    callback = callback,
                    actions = actionList
                )
            }
        }
    }
}
