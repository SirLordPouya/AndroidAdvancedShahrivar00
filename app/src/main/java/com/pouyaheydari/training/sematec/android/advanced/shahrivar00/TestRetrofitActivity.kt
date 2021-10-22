package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.databinding.ActivityTestRetrofitBinding
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.di.ClassA
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.models.MovieSearch
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TestRetrofitActivity : Fragment() {

    lateinit var binding: ActivityTestRetrofitBinding

    @Inject
    lateinit var db: AppDatabase

    @Inject
    lateinit var retrofit: TestRetrofitInterface

    @Inject
    lateinit var a: ClassA

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityTestRetrofitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAG", "onViewCreated: ")
        a.printHello()

        val adapter = SearchMovieRecyclerAdapter {
            lifecycleScope.launch(Dispatchers.IO) {
                db.searchDao().insertMovie(it)
            }
        }
        binding.recyclerMovies.adapter = adapter

        binding.btnSearch.setOnClickListener {
            val text = binding.edtMovieName.text.toString()

            val firstCall = lifecycleScope.async {
                retrofit.searchMoviesByTitle(text, "70ad462a5")
            }

            val secondCall = lifecycleScope.async {
                retrofit.searchMoviesByTitle(text, "70ad462a5")
            }


            lifecycleScope.launch(Dispatchers.IO) {
                Log.d("TAG", "onViewCreated: ${Thread.currentThread().name}")

                showResult(firstCall.await(),secondCall.await())

                try {
                    val result = retrofit.searchMoviesByTitle(text, "70ad462a5")
                    adapter.submitList(result.Search)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }

    fun showResult(first:MovieSearch,second:MovieSearch){

    }
}