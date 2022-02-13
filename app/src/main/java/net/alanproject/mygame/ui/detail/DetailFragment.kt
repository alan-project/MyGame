package net.alanproject.mygame.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import net.alanproject.mygame.R
import net.alanproject.mygame.databinding.FragmentDetailBinding



class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }
}