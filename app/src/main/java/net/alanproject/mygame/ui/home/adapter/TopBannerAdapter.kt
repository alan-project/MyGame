package net.alanproject.mygame.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemTopBannerBinding

class TopBannerAdapter(private val games: List<Result>) :
    RecyclerView.Adapter<TopBannerAdapter.TopBannerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopBannerViewHolder =
        TopBannerViewHolder(
            DataBindingUtil.inflate<ItemTopBannerBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_top_banner, parent, false
            )
        )


    override fun onBindViewHolder(holder: TopBannerViewHolder, position: Int) {
        val actualPosition = position % games.size
        holder.bind(games[actualPosition])
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class TopBannerViewHolder(
        private val binding: ItemTopBannerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Result) {
            binding.model = game

        }

    }
}