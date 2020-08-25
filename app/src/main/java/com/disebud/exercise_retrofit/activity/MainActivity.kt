package com.disebud.exercise_retrofit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.disebud.exercise_retrofit.container.MyApplication
import com.disebud.exercise_retrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // application == sebagai parent
     val appContainer = (application as MyApplication).appContainer
        appContainer.roomViewModel

        navController = (nav_main_host_fragment_container as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottom_navigation, navController)


        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.showGood -> {
                    navController.navigate(R.id.action_to_RoomFragment)
                    true
                }

                R.id.createGood -> {
                    navController.navigate(R.id.action_to_CreateRoomFragment)
                    true
                }
                else -> {
                    println("MASUK ELSE")
                    false
                }
            }
        }
    }


}

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import androidx.activity.viewModels
//import androidx.lifecycle.Observer
//import com.disebud.exercise_retrofit.artist.ArtistViewModel
//import kotlinx.android.synthetic.main.activity_main.*
//
//class MainActivity : AppCompatActivity() {
//    val artistViewModel by viewModels<ArtistViewModel>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        artistViewModel.artist.observe(this, Observer {
//            artistNameText1.text = "ID ROOM : ${it.id_room}"
//            artistNameText2.text = it.name_room
//            artistNameText3.text = it.location
//            artistNameText4.text = "PRICE : ${it.price.toString()}"
//        })
//    }
//
//    fun getArtist(view: View) {
//        artistViewModel.getArtist(artistInputText1.text.toString())
//    }
//}