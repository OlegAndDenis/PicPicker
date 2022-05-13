package com.project.unsplash_api.di

import com.project.retrofit_common.RetrofitFactory
import com.project.unsplash_api.UnsplashOkHttpConfig
import com.project.unsplash_api.UnsplashRetrofitConfig
import com.project.unsplash_api.api.UnsplashApi
import com.project.unsplash_api.interceptors.AuthInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Qualifier
import javax.inject.Singleton
import okhttp3.Interceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class UnsplashApiModule {

    @Binds
    @IntoSet
    @UnsplashApis
    abstract fun bindAuthInterceptor(authInterceptor: AuthInterceptor) : Interceptor

    companion object {
        @Provides
        @Singleton
        fun provideUnsplashApi(
            retrofitFactory: RetrofitFactory,
            unsplashRetrofitConfig: UnsplashRetrofitConfig,
            unsplashOkHttpConfig: UnsplashOkHttpConfig
        ): UnsplashApi = retrofitFactory
            .createRetrofit(
                retrofitConfig = unsplashRetrofitConfig,
                okHttpConfig = unsplashOkHttpConfig,
            ).create(UnsplashApi::class.java)
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnsplashApis