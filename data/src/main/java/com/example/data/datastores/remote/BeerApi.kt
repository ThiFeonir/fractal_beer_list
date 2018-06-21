package com.example.data.datastores.remote

import com.example.data.datastores.remote.interfaces.BeerApiDef
import com.example.data.datastores.remote.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class BeerApi {
    companion object {
        fun getOkHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient: OkHttpClient =
                    OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build()

            return okHttpClient
        }

        fun provideRetrofit(): Retrofit {
            val httpClient = getOkHttpClient()
            val retrofit = Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient)
                    .build()

            return retrofit
        }

        fun provideApiService(): BeerApiDef {
            return provideRetrofit()
                    .create(BeerApiDef::class.java)
        }
    }
}