package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.Search

@Dao
interface SearchDao {

    @Insert
    suspend fun insertMovie(movie: Search)

    @Query("SELECT * from Search")
    suspend fun getAllMovies(): List<Search>
}