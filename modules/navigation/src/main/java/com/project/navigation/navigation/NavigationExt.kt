package com.project.navigation.navigation

import androidx.navigation.*

private const val HIDE_BOTTOM_NAV_ARG = "HIDE_BOTTOM_NAV_ARG"

val hideBottomBundleArgument: NavArgument get() = hideBottomNamedArgument.argument

val hideBottomNamedArgument: NamedNavArgument
    get() = navArgument(HIDE_BOTTOM_NAV_ARG) {
        type = NavType.BoolType
        defaultValue = true
    }

val NavBackStackEntry?.hideBottomNavigation
    get() = this?.arguments?.getBoolean(
        HIDE_BOTTOM_NAV_ARG
    ) ?: false