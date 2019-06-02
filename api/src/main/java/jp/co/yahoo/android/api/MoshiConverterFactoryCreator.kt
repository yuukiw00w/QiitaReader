package jp.co.yahoo.android.api

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

object MoshiConverterFactoryCreator {
    operator fun invoke(): Converter.Factory {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return MoshiConverterFactory.create(moshi)
    }
}