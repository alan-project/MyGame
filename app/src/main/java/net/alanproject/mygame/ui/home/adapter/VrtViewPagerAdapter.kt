package net.alanproject.mygame.ui.home.adapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import net.alanproject.domain.util.Genre
import net.alanproject.mygame.common.GENRE_CNT
import net.alanproject.mygame.common.KEY_GENRE
import net.alanproject.mygame.ui.home.rank.RankFragment

class VrtViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int  = GENRE_CNT

    override fun createFragment(position: Int): Fragment {
        val genre = when(position){
            0->Genre.ACTION
            1->Genre.STRATEGY
            2->Genre.PUZZLE
            3->Genre.SPORT
            else->Genre.ACTION
        }
        return RankFragment().apply{
            arguments = bundleOf(KEY_GENRE to genre)
        }
    }
}
