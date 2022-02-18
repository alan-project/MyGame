package net.alanproject.mygame.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.common.KEY_ID
import net.alanproject.mygame.common.showHorizontalPreview

import net.alanproject.mygame.databinding.FragmentHomeBinding
import net.alanproject.mygame.ui.detail.DetailFragment
import net.alanproject.mygame.ui.home.adapter.HrzFullPagerAdapter
import net.alanproject.mygame.ui.home.adapter.HrzSubPagerAdapter
import net.alanproject.mygame.ui.home.adapter.VrtViewPagerAdapter
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
        initRankAdapter()
    }


    private fun getGames() {
        viewModel.onLoadGames()
    }

    private fun observing() {
        lifecycleScope.launchWhenStarted {
            viewModel.updateGames.collect { games ->
                initUpdatePagerAdapter(games)
            }
        }
        lifecycleScope.launchWhenStarted {

            viewModel.releaseGames.collect { games ->
                initNewPagerAdapter(games)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.upcomingGames.collect { games ->
                initUpcomingAdapter(games)
            }
        }
    }

    private fun initUpdatePagerAdapter(updateGames: List<Result>) {
        if (!updateGames.isNullOrEmpty()) {
            Timber.d("Pager[updateGames] : ${updateGames.first()}")
            val adapter = HrzFullPagerAdapter{game->
                val gameId:Int = game.id
                val intent = Intent(context, DetailFragment::class.java)
                    .putExtra(KEY_ID, gameId)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            binding.vpUpdate.adapter = adapter
            binding.vpUpdate.setCurrentItem(adapter.itemCount / 2, false)

        }
    }

    private fun initNewPagerAdapter(newGames: List<Result>) {

        if (!newGames.isNullOrEmpty()) {
            Timber.d("Pager[newGames] : ${newGames.first()}")
            val adapter = HrzSubPagerAdapter{game->
                val gameId:Int = game.id
                val intent = Intent(context, DetailFragment::class.java)
                    .putExtra(KEY_ID, gameId)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            binding.vpNew.adapter = adapter
            binding.vpNew.setCurrentItem(adapter.itemCount / 2, false)
            binding.vpNew.showHorizontalPreview()
        }
    }

    private fun initUpcomingAdapter(upcomingGames: List<Result>) {
        if (!upcomingGames.isNullOrEmpty()) {
            Timber.d("Pager[upcomingGames] : ${upcomingGames.first()}")
            val adapter = HrzSubPagerAdapter{game->
                val gameId:Int = game.id
                val intent = Intent(context, DetailFragment::class.java)
                    .putExtra(KEY_ID, gameId)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            binding.vpUpcoming.adapter = adapter
            binding.vpUpcoming.setCurrentItem(adapter.itemCount / 2, false)
            binding.vpUpcoming.showHorizontalPreview()
        }
    }

    private fun initRankAdapter() {


        binding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.vpRank.adapter = VrtViewPagerAdapter(requireActivity())

        TabLayoutMediator(binding.tabLayout,binding.vpRank){tab,position->
            when(position){
                0 -> tab.text ="ACTION"
                1 -> tab.text ="STRATEGY"
                2 -> tab.text ="PUZZLE"
                3 -> tab.text ="SPORT"
            }
        }.attach()
    }

}



