package com.disebud.exercise_retrofit.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object{
        val BASE_URL = "http://jsonplaceholder.typicode.com/"

        fun createRetrofit(): Retrofit{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}