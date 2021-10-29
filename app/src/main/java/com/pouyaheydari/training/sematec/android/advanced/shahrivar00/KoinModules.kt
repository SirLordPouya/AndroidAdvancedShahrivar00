package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import androidx.room.Room
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository.network.TestRetrofitInterface
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val roomModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "movie").build()
    }
}

val retrofitModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        retrofit.create(TestRetrofitInterface::class.java)
    }
}