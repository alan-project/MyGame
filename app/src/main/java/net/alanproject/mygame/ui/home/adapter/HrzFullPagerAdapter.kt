package net.alanproject.mygame.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemHrzFullBinding

class HrzFullPagerAdapter(private val games: List<Result>) :
    RecyclerView.Adapter<HrzFullPagerAdapter.HrzFullViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HrzFullViewHolder =
        HrzFullViewHolder(
            DataBindingUtil.inflate<ItemHrzFullBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_hrz_full, parent, false
            )
        )


    override fun onBindViewHolder(holder: HrzFullViewHolder, position: Int) {
        val actualPosition = position % games.size
        holder.bind(games[actualPosition])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class HrzFullViewHolder(
        private val binding: ItemHrzFullBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Result) {
            binding.model = game

        }

    }
}