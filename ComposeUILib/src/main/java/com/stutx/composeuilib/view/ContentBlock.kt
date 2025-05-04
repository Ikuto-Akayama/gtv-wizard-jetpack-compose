/*
 * Copyright 2025 Ikuto-Akayama, All rights reserved.
 */

package com.stutx.composeuilib.view

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stutx.composeuilib.R

@Composable
internal fun ContentBlock(
    @StringRes title: Int,
    @StringRes subtitle: Int? = null,
    @StringRes description: Int,
    @DrawableRes extraIcon: Int? = null,
    @StringRes extraLabel: Int? = null,
    @StringRes extraSubtitle: Int? = null,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.width(340.dp)
    ) {
        Heading(
            title = title,
            subtitle = subtitle,
            modifier = modifier
        )
        Description(
            description,
            modifier = modifier.padding(top = 16.dp)
        )
        Extra(
            extraIcon,
            extraLabel,
            extraSubtitle,
            modifier = modifier.padding(top = 16.dp)
        )
    }
}

@Composable
private fun Heading(
    @StringRes title: Int,
    @StringRes subtitle: Int? = null,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            modifier = modifier,
            text = stringResource(title),
            style = MaterialTheme.typography.headlineMedium,
        )
        subtitle?.let {
            Text(
                text = stringResource(subtitle),
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun Description(
    @StringRes description: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(description),
        style = MaterialTheme.typography.bodyLarge.copy(
            lineBreak = LineBreak.Paragraph
        ),
        modifier = modifier
    )
}

@Composable
private fun Extra(
    @DrawableRes icon: Int?,
    @StringRes label: Int?,
    @StringRes subtitle: Int?,
    modifier: Modifier = Modifier,
) {
    if (icon == null && label == null && subtitle == null) return
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val isTagExist = extraTag(icon = icon, label = label)
        subtitle?.let {
            Text(
                text = stringResource(it),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = if (isTagExist) 8.dp else 0.dp)
            )
        }
    }
}

@Composable
private fun extraTag(
    @DrawableRes icon: Int?,
    @StringRes label: Int?,
): Boolean {
    if (icon == null && label == null) return false
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
            .padding(
                vertical = 2.dp,
                horizontal = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
            )
        }
        label?.let {
            Text(
                text = stringResource(label),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(start = if (icon != null) 4.dp else 0.dp)
            )
        }
    }
    return true
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ExtraTagPreview() {
    Extra(
        icon = R.drawable.baseline_arrow_right_24,
        label = R.string.label_dialog_extra_tag,
        subtitle = R.string.label_dialog_subtitle
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockNoExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockSubtitleExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraSubtitle = R.string.label_dialog_subtitle,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockIconExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraIcon = R.drawable.baseline_arrow_right_24,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockLabelExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraLabel = R.string.label_dialog_extra_tag,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockIconAndLabelExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraIcon = R.drawable.baseline_arrow_right_24,
        extraLabel = R.string.label_dialog_extra_tag,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockIconAndSubtitleExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraIcon = R.drawable.baseline_arrow_right_24,
        extraSubtitle = R.string.label_dialog_subtitle,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockLabelAndSubtitleExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraLabel = R.string.label_dialog_extra_tag,
        extraSubtitle = R.string.label_dialog_subtitle,
        modifier = Modifier
    )
}

@Preview(
    locale = "en",
    showBackground = true,
    name = "ActionButton preview",
    device = Devices.TV_720p,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun ContentBlockFullExtraPreview() {
    ContentBlock(
        title = R.string.label_dialog_title,
        subtitle = R.string.label_dialog_subtitle,
        description = R.string.label_dialog_description,
        extraIcon = R.drawable.baseline_arrow_right_24,
        extraLabel = R.string.label_dialog_extra_tag,
        extraSubtitle = R.string.label_dialog_subtitle,
        modifier = Modifier
    )
}
