package jp.co.yahoo.android.api

import retrofit2.Retrofit

object RetrofitCreator {
    operator fun <T> invoke(url: String, clazz: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactoryCreator())
            .client(OkHttpClientCreator())
            .build()
        return retrofit.create(clazz)
    }
}