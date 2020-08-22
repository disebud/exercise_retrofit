package com.disebud.exercise_retrofit.artist

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistRepository (val artistAPI: ArtistAPI) {

    val artist: MutableLiveData<Artist> = MutableLiveData<Artist>()

    fun getArtist(id: String){
        artistAPI.getArtistByID(id).enqueue(object: Callback <WrapperResponse>{
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
                    val artistObject = gson.fromJson<Artist>(stringResult,Artist::class.java)
                    artist.value = artistObject
                }

            }
        })

    }

}