package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.mvp

class TestMVPModel {
   suspend fun getData(): List<String> {
        // internet
        val list = listOf("Pouya", "Alireza", "Javad", "Sahar", "Sina")
        return list
    }
}