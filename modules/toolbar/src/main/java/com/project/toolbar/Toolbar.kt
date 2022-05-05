package com.project.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

private const val TOOLBAR_HEIGHT = 50
private const val ICON_SIZE = 20

private const val DIVIDER_COLOR = 0xFFEDEDED
private const val DIVIDER_HEIGHT = 2

private const val ICON_COLOR = 0xFF9A9A9A
private const val TOOLBAR_HORIZONTAL_PADDING = 15

@Composable
fun Toolbar(navController: NavController, screens: Set<ToolbarConfig>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    screens
        .find { it.route == navBackStackEntry?.destination?.route }
        .takeIf { it?.showToolbar == true }
        ?.let { Toolbar(navController, it) }
}

@Composable
private fun Toolbar(navController: NavController, config: ToolbarConfig) {
    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(TOOLBAR_HORIZONTAL_PADDING.dp))

            SettingsButtonIcon(enabled = config.needSettingsButton) {
                // navigate to settings
            }

            Text(
                text = stringResource(id = config.labelRes),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center
            )

            SearchButtonIcon(enabled = config.needSearchButton) {
                // navigate to search
            }

            Box(Modifier.size(TOOLBAR_HORIZONTAL_PADDING.dp))

        }
        BottomDivider()
    }
}

@Composable
fun SettingsButtonIcon(enabled: Boolean, onClick: () -> Unit) =
    IconButton(enabled = enabled, drawableRes = R.drawable.ic_settings, onClick = onClick)

@Composable
fun SearchButtonIcon(enabled: Boolean, onClick: () -> Unit) =
    IconButton(enabled = enabled, drawableRes = R.drawable.ic_search, onClick = onClick)

@Composable
private fun IconButton(enabled: Boolean, @DrawableRes drawableRes: Int, onClick: () -> Unit) {
    IconButton(
        enabled = enabled,
        modifier = Modifier
            .size(TOOLBAR_HEIGHT.dp),
        onClick = onClick::invoke
    ) {
        if (enabled) Icon(drawableRes)
    }
}

@Composable
private fun Icon(@DrawableRes drawableRes: Int) {
    Icon(
        tint = Color(ICON_COLOR),
        imageVector = ImageVector.vectorResource(id = drawableRes),
        contentDescription = "",
        modifier = Modifier
            .size(ICON_SIZE.dp)
    )
}

@Composable
private fun BottomDivider() {
    Box(
        modifier = Modifier
            .background(Color(DIVIDER_COLOR))
            .fillMaxWidth()
            .height(DIVIDER_HEIGHT.dp)
    )
}
