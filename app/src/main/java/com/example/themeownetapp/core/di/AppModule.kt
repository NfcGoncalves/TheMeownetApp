package com.example.themeownetapp.core.di

import com.example.themeownetapp.BuildConfig
import com.example.themeownetapp.data.request.CatRequestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Used to log responses from Retrofit, here we see the body of the response
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    /*
    Here we create a network client and add the interceptor
    I like to see the API calls with body on Logcat to see what's going on
    */
    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    //Here we build our api to be provided
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .build()

    //here is our Cat Api provider
    @Singleton
    @Provides
    fun provideCatApi(retrofit: Retrofit): CatRequestApi = retrofit.create(CatRequestApi::class.java)
}