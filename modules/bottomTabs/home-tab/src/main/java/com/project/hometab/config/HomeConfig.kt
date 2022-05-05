package com.project.hometab.config

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.project.configuration.ConfigurationTab.home
import com.project.hometab.R
import com.project.hometab.screen.Home
import com.project.screenconfig.ScreenConfig
import javax.inject.Inject

class HomeConfig @Inject constructor() : ScreenConfig() {
    override val route: String = home

    override val showToolbar: Boolean = true
    @StringRes override val labelRes: Int = R.string.home_label
    override val needSearchButton: Boolean = true
    override val needSettingsButton: Boolean = true

    override val showBottomNavBar: Boolean = true
    @DrawableRes override val icon: Int = R.drawable.home_tab
    override val order: Int = 0
    override val isRoot: Boolean = true
    override val openScreen: @Composable () -> Unit = {
        Home()
    }
}