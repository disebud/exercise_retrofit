package com.disebud.exercise_retrofit.roomHotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.disebud.exercise_retrofit.config.RetrofitBuilder

class RoomViewModel(val roomRepository: RoomRepository): ViewModel() {

//    val roomRepository: RoomRepository
//
//    init {
//        val RoomAPI = RetrofitBuilder.createRetrofit().create(RoomAPI::class.java)
//        roomRepository = RoomRepository(RoomAPI)
//    }

    val room : LiveData<Room> = roomRepository.room

    fun getRoomId(id: String){
        roomRepository.getRoomId(id)
    }

    fun saveRoom(room: Room) {
        roomRepository.saveRoom(room)
    }
}