package com.example.unittest11_08_2021.retrofit.webserrvice


import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {

    companion object {
        private const val BASE_URL = "https://www.simplifiedcoding.net/demos/"

        fun getClient(): Retrofit? {

            val mRetrofit: Retrofit
            val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            mHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val mClient = OkHttpClient.Builder().addInterceptor(
                LoggingInterceptor.Builder()
                    .setLevel(Level.BASIC)
                    .request("Request")
                    .response("Response")
                    .build()
            )
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

            mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mClient)
                .build()

            return mRetrofit
        }
    }
}