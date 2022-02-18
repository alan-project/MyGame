package net.alanproject.mygame.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemListBinding
import net.alanproject.mygame.databinding.ItemRankHomeBinding
import timber.log.Timber

class ListRecyclerViewAdapter(
    private val games:MutableList<Result> = mutableListOf()

) : RecyclerView.Adapter<ListRecyclerViewAdapter.ListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val binding = DataBindingUtil.inflate<ItemListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list, parent, false
        )
        return ListHolder(binding)

    }

    fun update(newGames:MutableList<Result>){
        val startPos = games.size
        games.addAll(newGames)
        notifyItemRangeChanged(startPos, games.size)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int  = games.size
    class ListHolder(
        private val binding: ItemListBinding
    ):RecyclerView.ViewHolder(binding.root) {

        fun bind(game:Result){
            binding.model = game
            binding.executePendingBindings()
        }
    }
}