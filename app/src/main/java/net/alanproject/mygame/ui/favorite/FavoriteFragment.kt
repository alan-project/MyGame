package net.alanproject.mygame.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.FragmentFavoriteBinding
import net.alanproject.mygame.ui.detail.DetailViewModel

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
}