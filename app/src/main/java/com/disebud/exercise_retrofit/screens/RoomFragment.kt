package com.disebud.exercise_retrofit.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.disebud.exercise_retrofit.container.AppContainer
import com.disebud.exercise_retrofit.container.MyApplication
import com.disebud.exercise_retrofit.R
import kotlinx.android.synthetic.main.fragment_room.*

class RoomFragment : Fragment(), View.OnClickListener {

//    private val RoomViewModel by activityViewModels<RoomViewModel>()
    lateinit var  appContainer : AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer=(activity?.application as MyApplication).appContainer

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appContainer.roomViewModel.room.observe(viewLifecycleOwner, Observer {
            roomNameText.text = it.name_room
            priceRoomNameText.text = it.price.toString()
        })
        fetchButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            fetchButton -> getRoomByID()
        }
    }

    private fun getRoomByID() {
        appContainer.roomViewModel.getRoomId(roomIDInputText.text.toString())
    }
}

//RoomViewModel.room.observe(this, Observer {
//    artistNameText1.text = "ID ROOM : ${it.id_room}"
//    artistNameText2.text = it.name_room
//    artistNameText3.text = it.location
//    artistNameText4.text = "PRICE : ${it.price.toString()}"
//})