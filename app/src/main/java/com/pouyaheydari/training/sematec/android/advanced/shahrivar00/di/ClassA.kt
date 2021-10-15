package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.di

import android.util.Log
import javax.inject.Inject

class ClassA @Inject constructor(details: ClassB) {

    init {
        val b = details // dependency
        b.calculateAge()


    }

    fun printHello(){
        Log.d("TAG", "printHello: ")
    }
    fun printSomeDetails(b: PersonDetails){
        b.printAddress()
    }
}