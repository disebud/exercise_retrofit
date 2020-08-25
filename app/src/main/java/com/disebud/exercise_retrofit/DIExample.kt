package com.disebud.exercise_retrofit

fun main() {
    // tidak boleh krna bkan penerapan DIE
//    var EngineBensin = Engine().GasolineEngine
//    var EngineListrik = Engine().ElectricEngine
//    var engine: Engine = Engine()

    // 1 - Depedency Injection
//    var EngineBensin = GasolineEngine()
//    var EngineListrik = ElectricEngine()
//    var EngineDiesel = DieselEngine()
//    var EngineSteame = SteameEngine()
//    var mobilBensin = Car(EngineBensin)
//    var mobilListrik = Car(EngineListrik)
//    var mobilDiesel = Car(EngineDiesel)
//    var mobilUap = Car(EngineSteame)

    // 2 - Seetter Injection
    var EngineBensin = GasolineEngine()
    var EngineListrik = ElectricEngine()
//    var mobilBensin = Car()
////    mobilBensin.engine = EngineBensin
////    var mobilListrik = Car()
////    mobilListrik.engine = EngineListrik
    // cara 1
    var mobilBensin = Car()
    mobilBensin.engine = EngineBensin
    mobilBensin.startEngine()
    // cara 2
    var mobilListrik = Car(EngineListrik)
    mobilListrik.startEngine()

}

// 1)- depedency injection : Constructor Injection
// tidak adda batasan solusi hanya menggunakan Inheritance
// boleh menggunakan solusi interface , abstract

//class Car(var engine: Engine){
//
//}

// 2)- DI : Constrc Injection, Setter Injection

class Car(var engine: Engine? = null){

    fun startEngine(){
        engine?.start()
    }

}



// Open - Inheritance - di Class engine() dan subclass ()
// interface - di class dan subclass tanpa ()
// abstract class - di class Engine dan subclass ()
//open class Engine(){

// 2
    interface  Engine{

    fun start(){
            println("Mesin Bensin Menyala")

    }



    // tidak boleh krna bkan penerapan DIE
//    var GasolineEngine : GasolineEngine = GasolineEngine()
//    var ElectricEngine : ElectricEngine = ElectricEngine()
}


class GasolineEngine : Engine{

    override fun start() {
        println("Mesin Bensin Menyala")
    }

}

class ElectricEngine : Engine{

    override fun start() {
        println("Mesin Listrik Menyala")
    }

}

class DieselEngine : Engine{

}

class SteameEngine : Engine{

}


class Tire{

}