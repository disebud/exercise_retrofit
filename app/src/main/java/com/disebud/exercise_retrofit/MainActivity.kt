package com.disebud.exercise_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.disebud.exercise_retrofit.artist.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val artistViewModel by viewModels<ArtistViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        artistViewModel.artist.observe(this, Observer {
            artistNameText1.text = "ID ROOM : ${it.id_room}"
            artistNameText2.text = it.name_room
            artistNameText3.text = it.location
            artistNameText4.text = "PRICE : ${it.price.toString()}"
        })
    }

    fun getArtist(view: View) {
        artistViewModel.getArtist(artistInputText1.text.toString())
    }
}