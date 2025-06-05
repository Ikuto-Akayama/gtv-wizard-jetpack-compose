/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v2.view.component

import android.content.res.Configuration
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v2.data.Action
import com.stutx.composeuilib.v2.data.ActionRaw
import com.stutx.composeuilib.v2.viewmodel.ActionCallback

@Composable
fun ColumnButtons(
    actions: List<Action>,
    actionCallback: ActionCallback,
    modifier: Modifier,
    initialFocusId: Int = Int.MIN_VALUE
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
    ) {
        val focusIndex =
            actions.find { it.id == initialFocusId }?.id
                ?: actions.firstOrNull()?.id
        actions.forEachIndexed { index, action ->
            val focusRequester = remember { FocusRequester() }
            ActionButtonV2(
                action = action,
                actionCallback = actionCallback,
                focusRequester = focusRequester
            )
            if (focusIndex == action.id) {
                LaunchedEffect(Unit) { focusRequester.requestFocus() }
            }
        }
    }
}

@Composable
internal fun ActionButtonV2(
    action: Action,
    actionCallback: ActionCallback,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester
) {
    var focused by remember { mutableStateOf(false) }
    FilledTonalButton(
        onClick = {
            focusRequester.requestFocus()
            actionCallback.onSelected(action)
            focused = true
        },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .focusRequester(focusRequester)
            .onFocusChanged { state ->
                focused = state.isFocused
            }
            .fillMaxWidth()
            .scale(if (focused) 1.075f else 1f)
            .focusable()
        ,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 12.dp
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            action.getIcon()?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }
            if (action.getTitle() != null || action.getSubtitle() != null) {
                ActionTextsV2(
                    action = action,
                    modifier = modifier

                )
            }
        }
    }
}

@Composable
private fun ActionTextsV2(
    action: Action,
    modifier: Modifier = Modifier
) {
    Column {
        action.getTitle()?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier
                    .align(Alignment.Start),
            )
        }
        action.getSubtitle()?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodySmall,
                modifier = modifier
            )
        }
    }
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "TextContentBlock preview(raw)",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ColumnButtonPreview() {
    val dummyCallback = object : ActionCallback {
        override fun onSelected(action: Action) {
            /* nop */
        }
    }
    ColumnButtons(
        actions = listOf(
            ActionRaw(id = 0, title = "action1 button1"),
            ActionRaw(id = 1, title = "action1 button2", subtitle = "subtitle exist"),
            ActionRaw(
                id = 2,
                title = "action1 button3",
                icon = R.drawable.baseline_arrow_right_24
            ),
            ActionRaw(
                id = 3,
                title = "action1 button4",
                subtitle = "subtitle exist",
                icon = R.drawable.baseline_arrow_right_24
            ),
        ),
        actionCallback = dummyCallback,
        modifier = Modifier,
        initialFocusId = -1
    )
}