package com.project.screenconfig

import com.project.bottom_navigation.BottomNavigationUi
import com.project.toolbar.ToolbarConfig

abstract class ScreenConfig : ToolbarConfig, BottomNavigationUi {
    override val needSearchButton: Boolean = false
    override val needSettingsButton: Boolean = false
}