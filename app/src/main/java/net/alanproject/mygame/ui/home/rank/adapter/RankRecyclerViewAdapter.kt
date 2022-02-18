package net.alanproject.mygame.ui.home.rank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemRankHomeBinding

class RankRecyclerViewAdapter(

    private val games:MutableList<Result> = mutableListOf(),
    private val onClickListener:(Result)-> Unit
) : RecyclerView.Adapter<RankRecyclerViewAdapter.RankHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankHolder {
        val binding = DataBindingUtil.inflate<ItemRankHomeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_rank_home, parent, false
        )
        return RankHolder(binding,onClickListener)

    }

    override fun onBindViewHolder(holder: RankHolder, position: Int) {
        holder.bind(games[position])
    }

    fun update(newGames:List<Result>){
        val startPos = games.size
        games.addAll(newGames)
        notifyItemRangeChanged(startPos, games.size)
    }

    override fun getItemCount(): Int  = games.size
    class RankHolder(
        private val binding: ItemRankHomeBinding,
        private val onClickListener:(Result)->Unit
    ):RecyclerView.ViewHolder(binding.root) {

        fun bind(game:Result){
            binding.model = game
            binding.root.setOnClickListener {
                onClickListener(game)
            }
            binding.executePendingBindings()
        }
    }
}