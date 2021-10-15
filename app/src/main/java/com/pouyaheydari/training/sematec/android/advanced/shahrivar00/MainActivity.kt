package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // int age = 30;
    // double
    // float
    // char
    // long
    // String
    // val nameOfVal : ValueType = initial value
    val age: Int = 30
    val name = "Pouya"
    val pi = 3.14
    val height: Int? = null
    var family: String? = null
    lateinit var txtTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}