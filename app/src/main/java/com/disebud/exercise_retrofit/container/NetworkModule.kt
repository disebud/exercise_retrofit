package com.disebud.exercise_retrofit.container

import com.disebud.exercise_retrofit.config.RetrofitBuilder
import com.disebud.exercise_retrofit.roomHotel.RoomAPI
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideRoomAPI(): RoomAPI{
        return RetrofitBuilder.createRetrofit().create(RoomAPI::class.java)
    }
}