package net.alanproject.mygame.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.GameInfo
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemFavoriteListBinding
import timber.log.Timber

class FavoriteRecyclerViewAdapter(
    private val games:MutableList<GameInfo> = mutableListOf()

) : RecyclerView.Adapter<FavoriteRecyclerViewAdapter.FavoriteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = DataBindingUtil.inflate<ItemFavoriteListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_favorite_list, parent, false
        )
        return FavoriteViewHolder(binding)

    }

    fun update(newGames:MutableList<GameInfo>){
        Timber.d("[favorite] result: $newGames")
        val startPos = games.size
        games.addAll(newGames)
        notifyItemRangeChanged(startPos, games.size)

    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int  = games.size

    class FavoriteViewHolder(
        private val binding: ItemFavoriteListBinding
    ):RecyclerView.ViewHolder(binding.root) {

        fun bind(game:GameInfo){
            binding.model = game
            binding.executePendingBindings()
        }
    }
}