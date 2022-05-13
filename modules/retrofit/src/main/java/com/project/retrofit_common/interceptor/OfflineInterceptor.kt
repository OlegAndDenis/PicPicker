package com.project.retrofit_common.interceptor

import java.net.ConnectException
import java.util.concurrent.TimeUnit
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

internal object OfflineInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            chain.proceed(chain.request())
        } catch (e: ConnectException) {
            val cacheControl = CacheControl.Builder()
                .onlyIfCached()
                .maxStale(1, TimeUnit.DAYS)
                .build()

            val offlineRequest = chain.request().newBuilder()
                .removeHeader("Pragma")
                .cacheControl(cacheControl)
                .build()
            chain.proceed(offlineRequest)
        }
    }
}