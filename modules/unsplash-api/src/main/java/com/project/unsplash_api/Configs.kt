package com.project.unsplash_api

import com.project.retrofit_common.OkHttpConfig
import com.project.retrofit_common.RetrofitConfig
import com.project.unsplash_api.di.UnsplashApis
import javax.inject.Inject
import okhttp3.Interceptor

class UnsplashRetrofitConfig @Inject constructor() : RetrofitConfig(
    baseUrl = BuildConfig.BASE_URL
)

class UnsplashOkHttpConfig @Inject constructor(
    @UnsplashApis interceptors: Set<@JvmSuppressWildcards Interceptor>
) : OkHttpConfig(
    interceptors = interceptors
)