package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.databinding.ActivityTestRetrofitBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TestRetrofitActivity : Fragment() {
    lateinit var binding: ActivityTestRetrofitBinding

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
        val adapter = SearchMovieRecyclerAdapter {
            findNavController().navigate(
                TestRetrofitActivityDirections.actionTestRetrofitActivityToMovieDetailsFragment(
                    it
                )
            )
        }
        binding.recyclerMovies.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val retrofitInterface = retrofit.create(TestRetrofitInterface::class.java)

        binding.btnSearch.setOnClickListener {
            val text = binding.edtMovieName.text.toString()
            retrofitInterface.searchMoviesByTitle(text, "70ad462a")
                .enqueue(object : Callback<MovieSearch> {
                    override fun onResponse(
                        call: Call<MovieSearch>,
                        response: Response<MovieSearch>
                    ) {
                        adapter.submitList(response.body()?.Search)
                    }

                    override fun onFailure(call: Call<MovieSearch>, t: Throwable) {
                        Log.d("TAG", "onFailure: ${t.message}")
                    }

                })
        }

    }
}