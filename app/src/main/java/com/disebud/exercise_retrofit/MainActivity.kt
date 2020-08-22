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
            artistNameText1.text = "id : ${it.id}"
            artistNameText2.text = it.name
            artistNameText3.text = it.email
            artistNameText4.text = "city : ${it.address.city}"
        })
    }

    fun getArtist(view: View) {
        artistViewModel.getArtist(artistInputText1.text.toString())
    }
}