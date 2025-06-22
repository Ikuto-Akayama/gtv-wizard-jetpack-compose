/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v3.view.component

import android.content.res.Configuration
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.stutx.composeuilib.v2.data.Action
import com.stutx.composeuilib.v2.data.ActionRaw
import com.stutx.composeuilib.v3.viewmodel.ActionListener

@Composable
internal fun ComposableAction(
    action: Action,
    actionListener: ActionListener,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier,
) {
    var focused by remember { mutableStateOf(false) }
    FilledTonalButton(
        onClick = {
            focused = true
            focusRequester.requestFocus()
            actionListener.onFocused(action)
            actionListener.onClicked(action)
        },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { state ->
                focused = state.isFocused
                actionListener.onFocused(action)
            }
            .focusable()
            .scale(if (focused) 1.075f else 1f)
        ,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 12.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .weight(1f)
        ) {
            action.getIcon()?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.align(
                        alignment = Alignment.CenterVertically
                    )
                )
            }
            if (action.getTitle() != null || action.getSubtitle() != null) {
                ComposableActionText(action, modifier)
            }
        }
    }
}

@Composable
private fun ComposableActionText(
    action: Action,
    modifier: Modifier = Modifier
) {
    Column {
        action.getTitle()?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.align(Alignment.Start)
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
    name = "ComposableAction preview",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewComposableAction() {
    val dummyListener = object : ActionListener {
        override fun onClicked(action: Action) {
            /* nop */
        }

        override fun onFocused(action: Action) {
            /* nop */
        }
    }
    ComposableAction(
        action = ActionRaw(
            id = 0,
            title = "some text"
        ),
        actionListener = dummyListener,
        modifier = Modifier
        ,
        focusRequester = FocusRequester()
    )
}
