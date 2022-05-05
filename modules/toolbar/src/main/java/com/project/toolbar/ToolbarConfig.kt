package com.project.toolbar

interface ToolbarConfig {
    val route: String
    val showToolbar: Boolean

    val labelRes: Int

    val needSearchButton: Boolean
    val needSettingsButton: Boolean
}