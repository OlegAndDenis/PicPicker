package com.project.retrofit_common

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.project.retrofit_common.interceptor.NetworkInterceptor
import com.project.retrofit_common.interceptor.OfflineInterceptor
import com.project.retrofit_common.interceptor.StandardInterceptor
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.text.DateFormat
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : RetrofitFactory {
    override fun createRetrofit(
        retrofitConfig: RetrofitConfig,
        okHttpConfig: OkHttpConfig,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(retrofitConfig.baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(getOkHttpClient(okHttpConfig))
        .build()

    private val gson: Gson = GsonBuilder()
        .serializeNulls()
        .setDateFormat(DateFormat.LONG)
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create()

    private fun getOkHttpClient(okHttpConfig: OkHttpConfig): OkHttpClient {
        val cacheFile = File(context.cacheDir, okHttpConfig.cacheEndPath)
        val cache = Cache(cacheFile, okHttpConfig.cacheSize)
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(okHttpConfig.connectTimeoutInSeconds, TimeUnit.SECONDS)
            .readTimeout(okHttpConfig.readTimeoutInSeconds, TimeUnit.SECONDS)
            .writeTimeout(okHttpConfig.writeTimeoutInSeconds, TimeUnit.SECONDS)
            .apply {
                okHttpConfig.standardInterceptors.forEach(::addStandardInterceptor)
                okHttpConfig.interceptors.forEach(::addInterceptor)
            }
            .cache(cache)
            .build()
    }

}

private fun OkHttpClient.Builder.addStandardInterceptor(interceptor: StandardInterceptor) {
    when (interceptor) {
        StandardInterceptor.NetworkInterceptor -> addNetworkInterceptor(NetworkInterceptor)
        StandardInterceptor.OfflineInterceptor -> addInterceptor(OfflineInterceptor)
    }
}


