package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import android.widget.ImageView
import com.bumptech.glide.Glide

fun testFunction() {
    println("Test")
}

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}