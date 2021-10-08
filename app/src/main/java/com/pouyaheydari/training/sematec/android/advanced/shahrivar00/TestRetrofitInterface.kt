package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.MovieSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TestRetrofitInterface {

    @GET("/") // s = asdsa & apiKey = asdas
    fun searchMoviesByTitle(@Query("s") name: String, @Query("apikey") apiKey: String):Call<MovieSearch>
}