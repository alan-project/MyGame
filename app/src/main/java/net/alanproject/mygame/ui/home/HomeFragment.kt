package net.alanproject.mygame.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.FragmentHomeBinding
import net.alanproject.mygame.ui.home.adapter.TopBannerAdapter
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getGames()
        observing()
    }

    private fun observing() {
        lifecycleScope.launchWhenStarted {
            viewModel.games.collect { games ->
                initAdapter(games)
            }
        }
    }

    private fun initAdapter(games: List<Result>) {
//        Timber.d("games.size: ${games.size}")
        if(!games.isNullOrEmpty()){
            val adapter = TopBannerAdapter(games.take(5))
            binding.vpTopBanner.adapter = adapter
            binding.vpTopBanner.setCurrentItem(adapter.itemCount/2,false)

        }


    }

    private fun getGames() {
        viewModel.onLoadGames()
    }
}