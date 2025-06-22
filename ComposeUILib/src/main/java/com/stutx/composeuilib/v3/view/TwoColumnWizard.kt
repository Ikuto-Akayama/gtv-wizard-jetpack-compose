/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v3.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.v2.view.component.TextContentBlock
import com.stutx.composeuilib.v3.view.component.ColumnActions
import com.stutx.composeuilib.v3.viewmodel.ActionsViewModel
import com.stutx.composeuilib.v3.viewmodel.GuidanceViewModel

@Composable
fun TwoColumnWizard(
    modifier: Modifier,
    guidanceViewModel: GuidanceViewModel,
    actionsViewModel: ActionsViewModel,
) {
    val guidance by guidanceViewModel.guidance.collectAsState()

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
                contents = guidance,
                modifier = modifier
                    .width(340.dp)
                ,
            )
            ColumnActions(
                actionsViewModel,
                modifier
                    .width(268.dp)
            )
        }
    }
}
