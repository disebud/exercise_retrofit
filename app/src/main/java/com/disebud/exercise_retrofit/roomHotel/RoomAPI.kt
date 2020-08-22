package com.disebud.exercise_retrofit.roomHotel

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RoomAPI {
//    @GET("users/{id}")
    @GET("reservation/{id}")
//    fun getArtistByID(@Path("id") id: String): Call<WrapperResponse>
    fun getArtistByID(@Path("id") id: String): Call<WrapperResponse>

    @POST("reservation")
    fun createRoom(@Body room: Room) : Call<Room>
}