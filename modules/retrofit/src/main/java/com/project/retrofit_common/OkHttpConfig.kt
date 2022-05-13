package com.project.retrofit_common

import com.project.retrofit_common.interceptor.StandardInterceptor
import okhttp3.Interceptor

abstract class OkHttpConfig(
    val standardInterceptors: Set<StandardInterceptor> = mutableSetOf(
        StandardInterceptor.NetworkInterceptor,
        StandardInterceptor.OfflineInterceptor
    ),
    val interceptors: Set<Interceptor> = emptySet(),
    val cacheEndPath: String = "http-cache",
    val cacheSize: Long = 5 * 1024 * 1024L,
    val connectTimeoutInSeconds: Long = 15L,
    val readTimeoutInSeconds: Long = 20L,
    val writeTimeoutInSeconds: Long = 20L
)