package net.alanproject.mygame.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.ItemListBinding
import net.alanproject.mygame.databinding.ItemRankHomeBinding

class ListRecyclerViewAdapter(
    private val games:List<Result>

) : RecyclerView.Adapter<ListRecyclerViewAdapter.ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val binding = DataBindingUtil.inflate<ItemListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list, parent, false
        )
        return ListHolder(binding)

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