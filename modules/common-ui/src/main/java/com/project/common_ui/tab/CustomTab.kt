package com.project.common_ui.tab

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.semantics.Role

@Composable
fun CustomTab(modifier: Modifier, content: @Composable RowScope.() -> Unit) {
    Row(
        modifier
            .selectableGroup()
            .background(MaterialTheme.colors.surface),
        horizontalArrangement = Arrangement.Center,
        content = content
    )
}

@Composable
fun RowScope.CustomTab(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit,
    customTab: @Composable (animationProgress: Float) -> Unit,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    selectedContentColor: Color,
    unselectedContentColor: Color,
    animation: AnimationSpec<Float> = AnimationSpec,
) {
    Box(
        modifier
            .selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = null
            )
            .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        BottomNavigationTransition(
            selectedContentColor,
            unselectedContentColor,
            selected,
            animation
        ) { progress ->
            val animationProgress = if (alwaysShowLabel) 1f else progress
            customTab(animationProgress)
        }
    }
}

@Composable
private fun BottomNavigationTransition(
    activeColor: Color,
    inactiveColor: Color,
    selected: Boolean,
    durationAnimation: AnimationSpec<Float> = AnimationSpec,
    content: @Composable (animationProgress: Float) -> Unit,
) {
    val animationProgress by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = durationAnimation
    )

    val color = lerp(inactiveColor, activeColor, animationProgress)

    CompositionLocalProvider(
        LocalContentColor provides color.copy(alpha = 1f),
        LocalContentAlpha provides color.alpha,
    ) {
        content(animationProgress)
    }
}


private val AnimationSpec = TweenSpec<Float>(
    durationMillis = 300,
    easing = FastOutSlowInEasing
)