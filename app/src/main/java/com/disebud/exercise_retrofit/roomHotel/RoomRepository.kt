package com.disebud.exercise_retrofit.roomHotel

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoomRepository (val roomAPI: RoomAPI) {

    val room: MutableLiveData<Room> = MutableLiveData<Room>()

    fun getRoomId(id: String){
        roomAPI.getArtistByID(id).enqueue(object: Callback <WrapperResponse>{
            //jika gagal
            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println(t.localizedMessage)
        }
            //jika berhasil
            override fun onResponse(call: Call<WrapperResponse>, response: Response<WrapperResponse>) {
                if(response.code()==200){
                    val response = response.body()
                    val gson = Gson()
                    val stringResult = gson.toJson(response?.result)
                    val artistObject = gson.fromJson<Room>(stringResult,Room::class.java)
                    room.value = artistObject
                }

            }
        })
    }

    fun saveRoom(room: Room){
        roomAPI.createRoom(room).enqueue(object : Callback<Room> {
            //jika gagal
            override fun onFailure(call: Call<Room>, t: Throwable) {
                t.printStackTrace()
            }
            //jika berhasil
            override fun onResponse(call: Call<Room>, response: Response<Room>) {
                println(response.isSuccessful)
                }
        })
    }
}