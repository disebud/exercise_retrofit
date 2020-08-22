package com.disebud.exercise_retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.disebud.exercise_retrofit.roomHotel.RoomViewModel
import kotlinx.android.synthetic.main.fragment_room.*

class RoomFragment : Fragment(), View.OnClickListener {

    private val RoomViewModel by activityViewModels<RoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RoomViewModel.room.observe(viewLifecycleOwner, Observer {
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
        RoomViewModel.getRoomId(roomIDInputText.text.toString())
    }
}

//RoomViewModel.room.observe(this, Observer {
//    artistNameText1.text = "ID ROOM : ${it.id_room}"
//    artistNameText2.text = it.name_room
//    artistNameText3.text = it.location
//    artistNameText4.text = "PRICE : ${it.price.toString()}"
//})