package net.alanproject.mygame.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.GameInfo
import net.alanproject.mygame.R
import net.alanproject.mygame.ui.home.HomeFragmentDirections
import net.alanproject.mygame.databinding.ItemHrzFullBinding
import timber.log.Timber

class HrzFullPagerAdapter(
    private val games: MutableList<GameInfo> = mutableListOf()
) : RecyclerView.Adapter<HrzFullPagerAdapter.HrzFullViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HrzFullViewHolder {
        val binding = DataBindingUtil.inflate<ItemHrzFullBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_hrz_full, parent, false
        )
        return HrzFullViewHolder(binding)
    }

    //    fun update(newGameInfos: List<GameInfoInfoResp>) {
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


    override fun onBindViewHolder(holder: HrzFullViewHolder, position: Int) {
        if (!games.isNullOrEmpty()) {
            val actualPosition = position % games.size
            holder.bind(games[actualPosition])
        }

    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class HrzFullViewHolder(
        private val binding: ItemHrzFullBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(GameInfo: GameInfo) {
            binding.model = GameInfo
//            val navController = Navigation.findNavController(binding.root)
            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionFragHomeToDetailFragment(GameInfo.id)

                Navigation.findNavController(binding.root).navigate(action)
            }
        }
    }
}