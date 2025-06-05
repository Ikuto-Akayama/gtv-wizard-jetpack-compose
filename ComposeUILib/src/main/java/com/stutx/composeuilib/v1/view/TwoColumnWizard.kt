/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v1.view

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v1.data.Action
import com.stutx.composeuilib.v1.data.TwoColumnWizardData
import com.stutx.composeuilib.v1.data.TwoColumnWizardExtra
import com.stutx.composeuilib.v1.viewmodel.ActionCallback

@Composable
fun TwoColumnWizard(
    modifier: Modifier = Modifier,
    data: TwoColumnWizardData,
    callback: ActionCallback,
    actions: List<Action>,
) {
    Surface(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 28.dp, horizontal = 58.dp)
            .width(960.dp)
            .height(540.dp)
            .wrapContentSize()
        ,
    ) {
        TwoColumnContainer(
            modifier,
            data,
            callback,
            actions
        )
    }
}

@Composable
private fun TwoColumnContainer(
    modifier: Modifier = Modifier,
    data: TwoColumnWizardData,
    actionCallback: ActionCallback,
    actions: List<Action>
) {
    Row(
        modifier = modifier.width(700.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ContentBlock(
            title = data.title,
            subtitle = data.subtitle,
            description = data.description,
            extraIcon = data.extra?.icon,
            extraLabel = data.extra?.label,
            extraSubtitle = data.extra?.subtitle,
            modifier = modifier
        )
        ActionButtons(
            actionCallback,
            actions,
            modifier = modifier
        )
    }
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun TwoColumnWizardPreview() {
    val callback = object : ActionCallback {
        override fun onSelected(label: Int) {
            println("$label is clicked.")
        }
    }
    TwoColumnWizard(
        data = TwoColumnWizardData(
            title = R.string.label_dialog_title,
            subtitle = R.string.label_dialog_subtitle,
            description = R.string.label_dialog_description,
            extra = TwoColumnWizardExtra(
                R.drawable.baseline_arrow_right_24,
                R.string.label_dialog_extra_tag,
                R.string.label_dialog_subtitle
            )
        ),
        callback = callback,
        actions = listOf(
            Action(
                title = R.string.label_action_button_yes,
                icon = R.drawable.baseline_arrow_right_24
            ),
            Action(
                title = R.string.label_action_button_no,
                subtitle = R.string.label_dialog_subtitle,
                icon = R.drawable.baseline_arrow_right_24
            ),
        )
    )
}
