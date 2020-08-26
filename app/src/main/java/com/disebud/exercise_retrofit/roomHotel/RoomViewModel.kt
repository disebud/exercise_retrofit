package com.disebud.exercise_retrofit.roomHotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.disebud.exercise_retrofit.config.RetrofitBuilder
import javax.inject.Inject

class RoomViewModel @Inject constructor(var roomRepository: RoomRepository){
//    class RoomViewModel @Inject constructor (val roomRepository: RoomRepository): ViewModel() {
//    val roomRepository: RoomRepository
//
//    init {
//        val RoomAPI = RetrofitBuilder.createRetrofit().create(RoomAPI::class.java)
//        roomRepository = RoomRepository(RoomAPI)
//    }

    val room : LiveData<Room>? = roomRepository?.room

    fun getRoomId(id: String){
        roomRepository?.getRoomId(id)
    }

    fun saveRoom(room: Room) {
        roomRepository?.saveRoom(room)
    }
}