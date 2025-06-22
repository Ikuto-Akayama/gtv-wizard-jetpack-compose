/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v3.view.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v2.data.Action
import com.stutx.composeuilib.v2.data.ActionRaw
import com.stutx.composeuilib.v3.viewmodel.ActionListener
import com.stutx.composeuilib.v3.viewmodel.ActionsViewModel

@Composable
fun ColumnActions(
    viewModel: ActionsViewModel,
    modifier: Modifier,
) {
    val actions by viewModel.actions.collectAsState()
    val listener = viewModel.actionListener
    val initialFocus = viewModel.initialActionFocus

    ColumnComposableActions(
        actions,
        listener,
        initialFocus,
        modifier
    )
}

@Composable
private fun ColumnComposableActions(
    actions: List<Action>,
    listener: ActionListener,
    initialFocus: Int,
    modifier: Modifier,
) {
    val focusId = actions.find { it.id == initialFocus }?.id
        ?: actions.firstOrNull()?.id
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
    ) {
        actions.forEach { action ->
            val focusRequester = remember { FocusRequester() }
            ComposableAction(action, listener, focusRequester, modifier)
            if (focusId == action.id) {
                LaunchedEffect(Unit) { focusRequester.requestFocus() }
            }
        }
    }
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ColumnComposableActions preview",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewColumnActions() {
    val dummyListener = object : ActionListener {
        override fun onClicked(action: Action) {
            /* nop */
        }

        override fun onFocused(action: Action) {
            /* nop */
        }

    }
    ColumnComposableActions(
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
        listener = dummyListener,
        initialFocus = -1,
        modifier = Modifier,
    )
}
