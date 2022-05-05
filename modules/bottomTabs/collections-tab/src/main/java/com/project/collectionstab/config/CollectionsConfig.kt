package com.project.collectionstab.config

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.project.collectionstab.R
import com.project.collectionstab.screen.Collections
import com.project.configuration.ConfigurationTab
import com.project.screenconfig.ScreenConfig
import javax.inject.Inject

class CollectionsConfig @Inject constructor() : ScreenConfig() {
    override val route: String = ConfigurationTab.collections

    override val showToolbar: Boolean = true
    @StringRes override val labelRes: Int = R.string.collections_label

    override val showBottomNavBar: Boolean = true
    @DrawableRes override val icon: Int = R.drawable.collections_tab
    override val order: Int = 1
    override val openScreen: @Composable () -> Unit = {
        Collections()
    }
}