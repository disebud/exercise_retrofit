package com.disebud.exercise_retrofit.artist

class Artist(var id_room: String = ""
             , var name_room: String = ""
             , var price: Int = 0
             , var location : String = ""
             , var address: FullAddress){

}

class FullAddress (var street: String = ""
                   , var suite: String = ""
                   , var city: String = ""
                   , var zipcode: String = ""
                   , var geo: Any){

}

