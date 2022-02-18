package net.alanproject.mygame.binding

import android.widget.ImageView
import android.widget.ListAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.ui.home.rank.adapter.RankRecyclerViewAdapter
import net.alanproject.mygame.ui.list.adapter.ListRecyclerViewAdapter
import timber.log.Timber

@BindingAdapter("gameImage")
fun bindGameImage(view: ImageView, image: String?) {
    view.load(image){
        transformations(RoundedCornersTransformation())
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