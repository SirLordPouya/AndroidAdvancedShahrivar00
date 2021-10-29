package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository

import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.AppDatabase
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.MovieSearch
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.Search
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository.local.SearchDao
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository.network.TestRetrofitInterface
import javax.inject.Inject

const val API_KEY = "70ad462a"

class Repository @Inject constructor(val db: AppDatabase, val network: TestRetrofitInterface) {

    suspend fun saveMovie(data: Search) {
        db.searchDao().insertMovie(data)
    }

    suspend fun searchMovieByTitle(title: String): MovieSearch {
       return network.searchMoviesByTitle(title, API_KEY)
    }
}