package com.disebud.exercise_retrofit.artist

class Artist(var id: String = ""
             , var name: String = ""
             , var username: String = ""
             , var email: String = ""
             , var address: FullAddress){

}

class FullAddress (var street: String = ""
                   , var suite: String = ""
                   , var city: String = ""
                   , var zipcode: String = ""
                   , var geo: Any){

}

class WrapperResponse(var status: String = ""
              , var message: String = ""
              , var result: Any){

}