package com.pouyaheydari.training.sematec.android.advanced.lib

fun calculateAge(birthYear: Int) = 2021 - birthYear

fun printName(): Unit {
    val test = TestKotlin(30)
    val age:Any = 10
    
}

fun testWhen(number: Int) = when (number) {
    1 -> "Pouya"
    2 -> "Alireza"
    3 -> "Javad"
    4 -> "Sahar"
    5 -> "Sina"
    else -> "UnKnown Student!"
}

fun testFor(){
    for (i in 0..100){

    }
}


class TestKotlin(age: Int) {
    val s = String()
}
