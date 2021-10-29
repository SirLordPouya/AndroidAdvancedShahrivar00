package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.SearchMovieRecyclerAdapter
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.databinding.ActivityTestRetrofitBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestRetrofitFragment : Fragment() {

    lateinit var binding: ActivityTestRetrofitBinding
    private val viewModel by viewModels<TestRetrofitViewModel>()

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
            viewModel.saveData(it)
        }
        binding.recyclerMovies.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it.Search)
        }

        binding.btnSearch.setOnClickListener {
            val text = binding.edtMovieName.text.toString()
            viewModel.onSearchClicked(text)
        }
    }
}