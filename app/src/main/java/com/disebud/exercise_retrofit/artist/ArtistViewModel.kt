package com.disebud.exercise_retrofit.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.disebud.exercise_retrofit.config.RetrofitBuilder

class ArtistViewModel: ViewModel() {
    val artistRepository: ArtistRepository


    init {
        val artistAPI = RetrofitBuilder.createRetrofit().create(ArtistAPI::class.java)
        artistRepository = ArtistRepository(artistAPI)
    }

    val artist : LiveData<Artist> = artistRepository.artist

    fun getArtist(id: String){
        artistRepository.getArtist(id)
    }
}