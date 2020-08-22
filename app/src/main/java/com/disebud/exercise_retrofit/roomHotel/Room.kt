package com.disebud.exercise_retrofit.roomHotel

class Room(var id_room: String = ""
             , var name_room: String = ""
             , var price: Int = 0
             , var location : String = ""
             , var id_status : String = ""){

}

class FullAddress (var street: String = ""
                   , var suite: String = ""
                   , var city: String = ""
                   , var zipcode: String = ""
                   , var geo: Any){

}

