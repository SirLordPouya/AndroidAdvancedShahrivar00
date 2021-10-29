package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository.network

import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.MovieSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface TestRetrofitInterface {

    @GET("/") // s = asdsa & apiKey = asdas
    suspend fun searchMoviesByTitle(
        @Query("s") name: String,
        @Query("apikey") apiKey: String
    ): MovieSearch
}