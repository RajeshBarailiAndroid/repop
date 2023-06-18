package com.jptest.realogyapp.utils

import com.jptest.realogyapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConfigUtils {
    @Provides
    @Singleton
    @Named("parameter_string")
    fun getParam(): String {
        return BuildConfig.ACCESS_PARAMS
    }
}