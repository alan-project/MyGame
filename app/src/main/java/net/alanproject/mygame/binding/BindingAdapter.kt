package net.alanproject.mygame.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.ui.home.adapter.HrzFullPagerAdapter
import net.alanproject.mygame.ui.home.adapter.HrzSubPagerAdapter
import net.alanproject.mygame.ui.home.rank.adapter.RankRecyclerViewAdapter
import net.alanproject.mygame.ui.list.adapter.ListRecyclerViewAdapter
import timber.log.Timber

@BindingAdapter("gameImage")
fun bindGameImage(view: ImageView, image: String?) {
    view.load(image){
        transformations(RoundedCornersTransformation())
    }
}

@BindingAdapter("games_update")
fun bindUpdateGames(viewPager: ViewPager2, games: List<Result>?) {

    if(!games.isNullOrEmpty()){
        Timber.d("games.size:${games.size}")
        (viewPager.adapter as HrzFullPagerAdapter).update(games.toMutableList())
    }
}

@BindingAdapter("games_release")
fun bindReleaseGames(viewPager: ViewPager2, games: List<Result>?) {

    if(!games.isNullOrEmpty()){
        Timber.d("games.size:${games.size}")
        (viewPager.adapter as HrzSubPagerAdapter).update(games.toMutableList())
    }
}

@BindingAdapter("games_upcoming")
fun bindUpcomingGames(viewPager: ViewPager2, games: List<Result>?) {

    if(!games.isNullOrEmpty()){
        Timber.d("games.size:${games.size}")
        (viewPager.adapter as HrzSubPagerAdapter).update(games.toMutableList())
    }
}

@BindingAdapter("games_list")
fun bindListGames(recyclerView: RecyclerView, games: List<Result>?) {

    games?.let {
        Timber.d("games.size:${games.size}")
        (recyclerView.adapter as ListRecyclerViewAdapter).update(games.toMutableList())

    }
}

@BindingAdapter("games_rank")
fun bindRankGames(recyclerView: RecyclerView, games: List<Result>?) {

    games?.let {
        Timber.d("games.size:${games.size}")
        (recyclerView.adapter as RankRecyclerViewAdapter).update(games.toMutableList())

    }
}