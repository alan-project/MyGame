package net.alanproject.mygame.ui.home.rank

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
import net.alanproject.mygame.common.KEY_GENRE
import net.alanproject.mygame.databinding.FragmentRankHomeBinding
import net.alanproject.mygame.ui.home.rank.adapter.RankAdapter

@AndroidEntryPoint
class RankFragment : Fragment() {

    private lateinit var binding: FragmentRankHomeBinding
    private val viewModel: RankViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_rank_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        observing()
    }

    private fun observing() {
        lifecycleScope.launchWhenStarted {
            viewModel.games.collect { games ->
                initAdapter(games)
            }
        }
    }

    private fun getData() {
        val genres: String = arguments?.getString(KEY_GENRE).orEmpty()
        getGames(genres)
    }

    private fun getGames(genres: String) {
        viewModel.onLoadGames(genres)
    }

    private fun initAdapter(games: List<Result>) {
        binding.recyclerRank.adapter = RankAdapter(games.take(5))
    }
}