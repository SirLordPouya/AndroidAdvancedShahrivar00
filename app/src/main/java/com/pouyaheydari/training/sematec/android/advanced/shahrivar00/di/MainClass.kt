package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.di

class MainClass {

    fun main(args: Array<String>) {
        val c = ClassC()
        val b = ClassB(c)
        val a = ClassA(b)
        a.printSomeDetails(c)
    }
}