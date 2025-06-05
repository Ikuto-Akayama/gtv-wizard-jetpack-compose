
/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun BottomDialog(
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
            .padding(vertical = 24.dp, horizontal = 24.dp)
            .background(MaterialTheme.colorScheme.background)
            .wrapContentSize(align = Alignment.BottomCenter)
            .clip(RoundedCornerShape(14.dp))
        ,
        color = MaterialTheme.colorScheme.primary,
    ) {
        /** bottom half dialog */
        Box(
            modifier = modifier
                .padding(vertical = 24.dp, horizontal = 34.dp)
                .height(200.dp)
                .fillMaxWidth()
            ,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                TextContentBlock(
                    contents = contents,
                    modifier = modifier
                        .padding(end = 32.dp)
                        .wrapContentHeight()
                        .widthIn(max = 543.dp)
                    ,
                )
                ColumnButtons(
                    actions = actions,
                    actionCallback = actionCallback,
                    modifier = modifier
                        .wrapContentHeight()
                        .requiredWidth(268.dp)
                    ,
                )
            }
        }
    }
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "BottomDialog preview",
    device = Devices.TV_720p,
)
@Composable
private fun BottomDialogPreview() {
    val dummyCallback = object : ActionCallback {
        override fun onSelected(action: Action) {
            /* do something */
        }
    }
    BottomDialog(
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
