package com.disebud.exercise_retrofit.container

import android.app.Application
import com.disebud.exercise_retrofit.container.AppContainer

class MyApplication : Application(){
//    val appContainer: AppContainer = AppContainer()
    val applicationComponent : ApplicationComponent = DaggerApplicationComponent.create()
}