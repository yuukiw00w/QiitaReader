package jp.co.yahoo.android.api

import okhttp3.OkHttpClient

object OkHttpClientCreator {
    operator fun invoke(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}