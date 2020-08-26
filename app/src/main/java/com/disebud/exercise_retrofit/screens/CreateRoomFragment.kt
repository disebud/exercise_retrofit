package com.disebud.exercise_retrofit.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.disebud.exercise_retrofit.container.AppContainer
import com.disebud.exercise_retrofit.container.MyApplication
import com.disebud.exercise_retrofit.R
import com.disebud.exercise_retrofit.roomHotel.Room
import com.disebud.exercise_retrofit.roomHotel.RoomViewModel
import kotlinx.android.synthetic.main.fragment_create_room.*
import javax.inject.Inject

//import com.disebud.exercise_retrofit.R
//import com.disebud.exercise_retrofit.domains.good.Good
//import com.example.exercise_retrofit.domains.good.GoodViewModel

class CreateRoomFragment : Fragment() , View.OnClickListener {

//    private val RoomViewModel by activityViewModels<RoomViewModel>()
//    lateinit var  appContainer : AppContainer
@Inject lateinit var roomViewModel: RoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//       appContainer = (activity?.application as MyApplication).appContainer
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
                roomViewModel.saveRoom(room)
            }
        }

    }
//    fun createRoom(view: View) {
//        RoomViewModel.createRoom(Good())
//    }
}