package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.di

import javax.inject.Inject

class ClassB @Inject constructor(details: ClassC) : PersonDetails {

    override fun printName() {}
    override fun calculateAge() {}
    override fun printAddress() {}
}