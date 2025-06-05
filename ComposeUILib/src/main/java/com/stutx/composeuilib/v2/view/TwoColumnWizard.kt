/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v2.data.Action
import com.stutx.composeuilib.v2.data.ActionRaw
import com.stutx.composeuilib.v2.data.ActionRes
import com.stutx.composeuilib.v2.data.TextContents
import com.stutx.composeuilib.v2.data.TextContentsRaw
import com.stutx.composeuilib.v2.view.component.ColumnButtons
import com.stutx.composeuilib.v2.view.component.TextContentBlock
import com.stutx.composeuilib.v2.viewmodel.ActionCallback

@Composable
fun TwoColumnWizard(
    contents: TextContents,
    actions: List<Action>,
    actionCallback: ActionCallback,
    modifier: Modifier = Modifier
) {
    /** whole screen */
    Surface(
        modifier = modifier
            .width(960.dp)
            .height(540.dp)
            .padding(vertical = 28.dp, horizontal = 58.dp)
            .wrapContentSize(align = Alignment.Center)
        ,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(15.dp) // FIXME: This is workaround.
                .width(700.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        ) {
            TextContentBlock(
                contents = contents,
                modifier = modifier
                    .width(340.dp)
                ,
            )
            ColumnButtons(
                actions = actions,
                actionCallback = actionCallback,
                modifier = modifier
                    .width(268.dp)
                ,
            )
        }
    }
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "TwoColumnWizard preview",
    device = Devices.TV_720p,
)
@Composable
private fun TwoColumnWizardPreview() {
    val dummyCallback = object : ActionCallback {
        override fun onSelected(action: Action) {
            /* do something */
        }
    }
    TwoColumnWizard(
        contents = TextContentsRaw(
            title = "test title",
            subtitle = "test subtitle",
            description = "this is description!!!! toooooooooooooooooooooooo long text can set this. also line break is automatically",
        ),
        actions = listOf(
            ActionRaw(id = 0, title = "raw action 1"),
            ActionRes(id = 1, title = R.string.label_action_button_yes)
        ),
        actionCallback = dummyCallback,
        modifier = Modifier
    )
}