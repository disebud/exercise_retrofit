package com.disebud.exercise_retrofit.artist

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistAPI {
    @GET("users/{id}")
    fun getArtistByID(@Path("id") id: String): Call<Artist>
}