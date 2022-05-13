package com.project.retrofit_common

import retrofit2.Retrofit

interface RetrofitFactory {
    fun createRetrofit(
        retrofitConfig: RetrofitConfig,
        okHttpConfig: OkHttpConfig
    ): Retrofit
}