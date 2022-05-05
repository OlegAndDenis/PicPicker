package com.project.download.config

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.project.configuration.ConfigurationTab
import com.project.download.R
import com.project.download.screen.Download
import com.project.screenconfig.ScreenConfig
import javax.inject.Inject

class DownloadConfig @Inject constructor() : ScreenConfig() {
    override val route: String = ConfigurationTab.download

    override val showToolbar: Boolean = true
    @StringRes override val labelRes: Int = R.string.download_label

    override val showBottomNavBar: Boolean = true
    @DrawableRes override val icon: Int = R.drawable.download_tab
    override val order: Int = 2
    override val openScreen: @Composable () -> Unit = {
        Download()
    }
}