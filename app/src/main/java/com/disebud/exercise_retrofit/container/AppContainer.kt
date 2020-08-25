package com.disebud.exercise_retrofit.container

import com.disebud.exercise_retrofit.config.RetrofitBuilder
import com.disebud.exercise_retrofit.roomHotel.RoomAPI
import com.disebud.exercise_retrofit.roomHotel.RoomRepository
import com.disebud.exercise_retrofit.roomHotel.RoomViewModel

class AppContainer {
    val roomApi : RoomAPI = RetrofitBuilder.createRetrofit().create(RoomAPI::class.java)
    val roomRepository : RoomRepository = RoomRepository(roomApi)
    val roomViewModel : RoomViewModel = RoomViewModel(roomRepository)
//    val RoomViewModelFactory :


}