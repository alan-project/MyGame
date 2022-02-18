package net.alanproject.mygame.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import net.alanproject.domain.model.response.games.Result
import net.alanproject.mygame.R
import net.alanproject.mygame.common.LinearRecyclerViewScrollListener
import net.alanproject.mygame.databinding.FragmentListBinding
import net.alanproject.mygame.ui.list.adapter.ListRecyclerViewAdapter

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()

    private val scrollListener: RecyclerView.OnScrollListener by lazy {
        LinearRecyclerViewScrollListener(callback = viewModel::onLoadingGames)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onLoadingGames()
        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = ListRecyclerViewAdapter()
        binding.recyclerView.addOnScrollListener(scrollListener)
    }

}