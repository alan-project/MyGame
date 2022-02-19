package net.alanproject.mygame.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.GameInfo
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemHrzSubBinding
import net.alanproject.mygame.ui.home.HomeFragmentDirections
import timber.log.Timber

class HrzSubPagerAdapter(
    private val games: MutableList<GameInfo> = mutableListOf()
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

    //    fun update(newGameInfos: List<GameInfoResp>) {
//        Timber.d("newGameInfos.size: ${newGameInfos.size}")
//        val startPos = GameInfos.size
//        GameInfos.addAll(newGameInfos)
//        notifyItemRangeChanged(startPos, GameInfos.size)
//    }
    fun update(newGames: List<GameInfo>) {
        Timber.d("newGameInfos.size: ${newGames.size}")
        games.clear()
        games.addAll(newGames)
        notifyDataSetChanged()
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

        fun bind(game: GameInfo) {
            binding.model = game
            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionFragHomeToDetailFragment(game.id)

                Navigation.findNavController(binding.root).navigate(action)
            }

        }

    }
}