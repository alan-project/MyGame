package net.alanproject.mygame.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemHrzFullBinding
import net.alanproject.mygame.databinding.ItemHrzSubBinding

class HrzSubPagerAdapter(private val games: List<Result>) :
    RecyclerView.Adapter<HrzSubPagerAdapter.HrzSubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HrzSubViewHolder =
        HrzSubViewHolder(
            DataBindingUtil.inflate<ItemHrzSubBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_hrz_sub, parent, false
            )
        )


    override fun onBindViewHolder(holder: HrzSubViewHolder, position: Int) {
        val actualPosition = position % games.size
        holder.bind(games[actualPosition])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class HrzSubViewHolder(
        private val binding: ItemHrzSubBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Result) {
            binding.model = game

        }

    }
}