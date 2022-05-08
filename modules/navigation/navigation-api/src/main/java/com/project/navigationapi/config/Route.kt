package com.project.navigationapi.config

sealed class Route {
    abstract val routeScheme: String
}

object ProfileRoute : Route() {
    private const val route: String = "profile"
    override val routeScheme: String = route
}

object DownloadRoute : Route() {
    private const val route: String = "download"
    override val routeScheme: String = route
}

object CollectionsRoute : Route() {
    private const val route: String = "collections"
    override val routeScheme: String = route

}

object HomeRoute : Route() {
    private const val route: String = "home"
    const val scheme: String = "type"
    override val routeScheme: String = "$route/{$scheme}"

    fun createRoute(type: String): String = "$route/$type"
}