package com.project.profile.config

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.project.configuration.ConfigurationTab
import com.project.profile.R
import com.project.profile.screen.Profile
import com.project.screenconfig.ScreenConfig
import javax.inject.Inject

class ProfileConfig @Inject constructor() : ScreenConfig() {
    override val route: String = ConfigurationTab.profile

    override val showToolbar: Boolean = true
    @StringRes override val labelRes: Int = R.string.profile_label

    override val showBottomNavBar: Boolean = true
    @DrawableRes override val icon: Int = R.drawable.profile_tab
    override val order: Int = 3
    override val openScreen: @Composable () -> Unit = {
        Profile()
    }
}