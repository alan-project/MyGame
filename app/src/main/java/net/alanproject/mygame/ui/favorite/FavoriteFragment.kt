package net.alanproject.mygame.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.FragmentFavoriteBinding
import net.alanproject.mygame.ui.favorite.adapter.FavoriteRecyclerViewAdapter

@AndroidEntryPoint
class FavoriteFragment: Fragment() {


    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
        DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onLoadGames()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvFavorite.adapter = FavoriteRecyclerViewAdapter()
    }
}