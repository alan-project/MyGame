package net.alanproject.mygame.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()

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
}