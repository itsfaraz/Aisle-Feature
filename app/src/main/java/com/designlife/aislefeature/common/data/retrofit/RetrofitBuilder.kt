package com.designlife.aislefeature.common.data.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    var ACCESS_TOKEN : String = ""

    private val interceptor = Interceptor{ chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization","Bearer ${ACCESS_TOKEN}")
            .build()

        return@Interceptor try {
            chain.proceed(request)
        }catch (e : Exception){
            Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(599)
                .message(e.message ?: "TimeOutException")
                .body(e.printStackTrace().toString().toResponseBody(null))
                .build()
        }
    }

    fun getRetrofit(baseUrl : String) : Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }

}