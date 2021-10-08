package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieSearch(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

@JsonClass(generateAdapter = true)
@Entity
data class Search(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    @PrimaryKey
    val imdbID: String
)

