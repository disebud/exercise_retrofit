package com.disebud.exercise_retrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.disebud.exercise_retrofit.roomHotel.Room
import com.disebud.exercise_retrofit.roomHotel.RoomViewModel
import kotlinx.android.synthetic.main.fragment_create_room.*
import kotlinx.android.synthetic.main.fragment_room.*

//import com.disebud.exercise_retrofit.R
//import com.disebud.exercise_retrofit.domains.good.Good
//import com.example.exercise_retrofit.domains.good.GoodViewModel

class CreateRoomFragment : Fragment() , View.OnClickListener {

    private val RoomViewModel by activityViewModels<RoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitRoomBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            submitRoomBtn -> {
                val room = Room(id_room = IdRoomInput.text.toString()
                    ,name_room = RoomNameInput.text.toString()
                    ,location = locationInput.text.toString()
                    ,price = PriceInput.inputType
                    ,id_status = StatusInput.text.toString())
                RoomViewModel.saveRoom(room)
            }
        }

    }
//    fun createRoom(view: View) {
//        RoomViewModel.createRoom(Good())
//    }
}