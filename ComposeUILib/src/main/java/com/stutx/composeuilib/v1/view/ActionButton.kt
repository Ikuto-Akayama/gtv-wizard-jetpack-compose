/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.v1.view

import android.content.res.Configuration
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R
import com.stutx.composeuilib.v1.data.Action
import com.stutx.composeuilib.v1.viewmodel.ActionCallback

@Composable
fun ActionButtons(
    actionCallback: ActionCallback,
    actions: List<Action>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(268.dp)
    ) {
        actions.forEach { action ->
            ActionButton(
                title = action.title,
                subtitle = action.subtitle,
                icon = action.icon,
                action = actionCallback,
            )
        }
    }
}

@Composable
fun ActionButton(
    @StringRes title: Int,
    action: ActionCallback,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    @StringRes subtitle: Int? = null,
) {
    FilledTonalButton(
        onClick = {
            action.onSelected(title)
        },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
        ,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 12.dp
        )
    ) {
        Row {
            icon?.let {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = modifier.align(Alignment.CenterVertically)
                )
            }
            ActionTexts(
                title = title,
                subtitle = subtitle,
                modifier = modifier
                    .padding(start = if (icon != null) 12.dp else 0.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ActionTexts(
    @StringRes title: Int,
    @StringRes subtitle: Int? = null,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.align(Alignment.Start)
        )
        subtitle?.let {
            Text(
                text = stringResource(it),
                style = MaterialTheme.typography.bodySmall,
                modifier = modifier
            )
        }
    }
}

@Preview(
    locale = "jp",
    showBackground = true,
    name = "ActionButton preview",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ActionButtonPreview() {
    val callback = object : ActionCallback {
        override fun onSelected(@StringRes id: Int) {
            Log.d("ActionButtonPreview","$id is clicked.")
        }
    }
    ActionButtons(
        actionCallback = callback,
        actions = listOf(
            Action(
                title = R.string.label_action_button_yes,
            ),
            Action(
                title = R.string.label_action_button_no,
                subtitle = R.string.label_dialog_subtitle,
                icon = R.drawable.baseline_arrow_right_24
            ),
        ),
    )
}
