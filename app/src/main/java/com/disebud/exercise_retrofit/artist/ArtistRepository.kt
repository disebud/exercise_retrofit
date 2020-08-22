package com.disebud.exercise_retrofit.artist

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistRepository (val artistAPI: ArtistAPI) {

    var artist: MutableLiveData<Artist> = MutableLiveData<Artist>()

    fun getArtist(id: String){
        artistAPI.getArtistByID(id).enqueue(object : Callback<Artist>{
            //jika gagal
            override fun onFailure(call: Call<Artist>, t: Throwable) {
                println(t.localizedMessage)
        }
            //jika berhasil
            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                artist.value = response.body()
            }

        })

    }

}