package net.alanproject.mygame.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemHrzSubBinding
import net.alanproject.mygame.ui.home.HomeFragmentDirections

class HrzSubPagerAdapter(
    private val games: MutableList<Result> = mutableListOf()
) : RecyclerView.Adapter<HrzSubPagerAdapter.HrzSubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HrzSubViewHolder {
        val binding = DataBindingUtil.inflate<ItemHrzSubBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_hrz_sub, parent, false
        )
        return HrzSubViewHolder(
            binding
        )

    }

    fun update(newGames: List<Result>) {
        val startPos = games.size
        games.addAll(newGames)
        notifyItemRangeChanged(startPos, newGames.size)
    }

    override fun onBindViewHolder(holder: HrzSubViewHolder, position: Int) {
        if (!games.isNullOrEmpty()) {
            val actualPosition = position % games.size
            holder.bind(games[actualPosition])
        }

    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class HrzSubViewHolder(
        private val binding: ItemHrzSubBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Result) {
            binding.model = game
            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionFragHomeToDetailFragment(game.id)

                Navigation.findNavController(binding.root).navigate(action)
            }

        }

    }
}