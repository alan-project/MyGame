package net.alanproject.mygame.ui.home.rank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import net.alanproject.mygame.ui.home.HomeFragmentDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.GameInfo
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemRankHomeBinding
import timber.log.Timber

class RankRecyclerViewAdapter(

    private val games: MutableList<GameInfo> = mutableListOf()
) : RecyclerView.Adapter<RankRecyclerViewAdapter.RankHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankHolder {
        val binding = DataBindingUtil.inflate<ItemRankHomeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_rank_home, parent, false
        )
        return RankHolder(binding)

    }

    override fun onBindViewHolder(holder: RankHolder, position: Int) {
        holder.bind(games[position])
    }

    fun update(newGameInfos: List<GameInfo>) {
        Timber.d("newGameInfos.size: ${newGameInfos.size}")
        val startPos = games.size
        games.addAll(newGameInfos)
        notifyItemRangeChanged(startPos, games.size)
    }

    override fun getItemCount(): Int = games.size
    class RankHolder(
        private val binding: ItemRankHomeBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(GameInfo: GameInfo) {
            binding.model = GameInfo
            binding.root.setOnClickListener {
                val action = HomeFragmentDirections.actionFragHomeToDetailFragment(GameInfo.id)

                Navigation.findNavController(binding.root).navigate(action)
            }

            binding.executePendingBindings()
        }
    }
}