package com.disebud.exercise_retrofit.container

import com.disebud.exercise_retrofit.activity.MainActivity
import com.disebud.exercise_retrofit.screens.CreateRoomFragment
import com.disebud.exercise_retrofit.screens.RoomFragment
import dagger.Component


@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(roomFragment: RoomFragment)
    fun inject(createRoomFragment: CreateRoomFragment)

}