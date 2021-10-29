package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.MovieSearch
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.Search
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestRetrofitViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val liveData = MutableLiveData<MovieSearch>()

    fun saveData(data: Search) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveMovie(data)
        }
    }

    fun onSearchClicked(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.searchMovieByTitle(title)
            liveData.postValue(result)
        }
    }

}