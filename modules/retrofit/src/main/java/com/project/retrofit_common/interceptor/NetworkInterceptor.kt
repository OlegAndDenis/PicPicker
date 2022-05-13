package com.project.retrofit_common.interceptor

import java.util.concurrent.TimeUnit
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

internal object NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val cacheHeader = response.header("CACHE_HEADER")

        if (cacheHeader == null || cacheHeader.contains("no-cache")
            || cacheHeader.contains("max-stale=0")
        ) {

            val cacheControl = CacheControl.Builder()
                .maxAge(15, TimeUnit.MINUTES)
                .build()

            val cacheRequest = request.newBuilder()
                .removeHeader("Pragma")
                .cacheControl(cacheControl)
                .build()

            return chain.proceed(cacheRequest)
        } else {
            return response
        }
    }
}