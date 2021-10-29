package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.Search
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository.local.SearchDao
import javax.inject.Inject

@Database(entities = [Search::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun searchDao(): SearchDao
}