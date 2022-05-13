package com.project.retrofit_common

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RetrofitModule {
    @Binds
    @Singleton
    abstract fun bindRetrofitFactory(retrofitFactoryImpl: RetrofitFactoryImpl): RetrofitFactory
}